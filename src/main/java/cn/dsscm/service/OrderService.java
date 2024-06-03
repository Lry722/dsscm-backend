package cn.dsscm.service;

import java.math.BigDecimal;
import java.util.List;

import cn.dsscm.dto.OrderQuery;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.vo.OrderDetails;
import cn.dsscm.vo.SaleLast24H;

public interface OrderService {

    PageInfo<OrderDetails> getList(OrderQuery queryParams);

    void delete(Integer id);

    BigDecimal getSalesToday();

    BigDecimal getSalesMonth();
    
    List<SaleLast24H> getSalesLast24H();
}
