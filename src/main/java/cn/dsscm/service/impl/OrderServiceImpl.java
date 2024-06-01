package cn.dsscm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import cn.dsscm.dao.OrderMapper;
import cn.dsscm.dto.OrderQuery;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.service.OrderService;
import cn.dsscm.vo.OrderDetails;
import lombok.RequiredArgsConstructor;
import cn.dsscm.pojo.Order;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    
    @Override
    public PageInfo<OrderDetails> getList(OrderQuery queryParams) {
        Page<Order> page = queryParams.startPage();
        List<Order> orders = orderMapper.selectList(queryParams);
        ArrayList<OrderDetails> result = new ArrayList<>();
        for (Order order : orders) {
            OrderDetails orderDetails = new OrderDetails();
            BeanUtils.copyProperties(order, orderDetails);
            orderDetails.setDetails(orderMapper.selectDetailList(order.getId()));
            result.add(orderDetails);
        }
        return new PageInfo<OrderDetails>(page.getTotal(), result);
    }

    @Override
    public void delete(Integer id) {
        orderMapper.delete(id);
    }
    
}
