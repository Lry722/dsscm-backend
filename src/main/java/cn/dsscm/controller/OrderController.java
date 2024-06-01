package cn.dsscm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dsscm.common.Result;
import cn.dsscm.dto.OrderQuery;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.pojo.Order;
import cn.dsscm.service.OrderService;
import cn.dsscm.vo.OrderDetails;
import lombok.RequiredArgsConstructor;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public Result<PageInfo<OrderDetails>> getOrderList(OrderQuery queryParams) {
        return Result.success(orderService.getList(queryParams));
    }
    
    @Delete("/{id}")
    public Result<Void> deleteOrder(@PathVariable Integer id) {
        orderService.delete(id);
        return Result.success();
    }
}
