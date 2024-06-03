package cn.dsscm.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import cn.dsscm.dao.OrderMapper;
import cn.dsscm.dao.ProductCategoryMapper;
import cn.dsscm.dao.ProductMapper;
import cn.dsscm.dto.OrderQuery;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.service.OrderService;
import cn.dsscm.vo.OrderDetails;
import cn.dsscm.vo.ProductCategoryNested;
import cn.dsscm.vo.SaleLast24H;
import lombok.RequiredArgsConstructor;
import cn.dsscm.pojo.Order;
import cn.dsscm.pojo.Product;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final ProductCategoryMapper productCategoryMapper;
    
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

    @Override
    public BigDecimal getSalesToday() {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        return orderMapper.selectSalesBetween(startOfDay, null);
    }

    @Override
    public BigDecimal getSalesMonth() {
        LocalDateTime startOfMonth = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        return orderMapper.selectSalesBetween(startOfMonth, null);
    }

    @Override
    public List<SaleLast24H> getSalesLast24H() {
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusDays(1);
        List<SaleLast24H> sales = new ArrayList<>();
        List<ProductCategoryNested> categories = productCategoryMapper.selectList();
        for (ProductCategoryNested category : categories) {
            SaleLast24H sale = new SaleLast24H();
            sale.setProductName(category.getName());
            ArrayList<BigDecimal> data = new ArrayList<>();
            for (LocalDateTime time = start; time.isBefore(end); time = time.plusHours(1)) {
                data.add(orderMapper.selectCategoryLevel1SalesBetween(time, time.plusHours(1), category.getId()));
            }
            sale.setData(data);
            sales.add(sale);
        }
        return sales;
    }
    
}
