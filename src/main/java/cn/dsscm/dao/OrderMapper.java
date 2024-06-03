package cn.dsscm.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.dsscm.dto.OrderQuery;
import cn.dsscm.pojo.Order;
import cn.dsscm.vo.OrderDetail;

@Mapper
public interface OrderMapper {

    List<Order> selectList(OrderQuery queryParams);

    List<OrderDetail> selectDetailList(Integer orderId);

    @Delete("DELETE FROM `order` WHERE id = #{id}")
    void delete(Integer id);

    // 查询某个时间段的销售额，左开右闭
    BigDecimal selectSalesBetween(LocalDateTime beginTime, LocalDateTime endTime);

    BigDecimal selectCategoryLevel1SalesBetween(LocalDateTime beginTime, LocalDateTime endTime, Integer categoryId);
    
}
