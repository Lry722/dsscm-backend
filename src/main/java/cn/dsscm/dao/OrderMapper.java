package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import cn.dsscm.dto.OrderQuery;
import cn.dsscm.pojo.Order;
import cn.dsscm.vo.OrderDetail;

@Mapper
public interface OrderMapper {

    List<Order> selectList(OrderQuery queryParams);

    List<OrderDetail> selectDetailList(Integer orderId);

    @Delete("DELETE FROM `order` WHERE id = #{id}")
    void delete(Integer id);
    
}
