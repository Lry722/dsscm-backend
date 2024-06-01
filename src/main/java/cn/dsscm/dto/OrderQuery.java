package cn.dsscm.dto;

import cn.dsscm.pojo.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OrderQuery extends BaseQuery<Order> {
    private String customerName;
    private Integer status;
}
