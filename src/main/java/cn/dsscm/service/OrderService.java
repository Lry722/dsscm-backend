package cn.dsscm.service;

import cn.dsscm.dto.OrderQuery;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.vo.OrderDetails;

public interface OrderService {

    PageInfo<OrderDetails> getList(OrderQuery queryParams);

    void delete(Integer id);
    
}
