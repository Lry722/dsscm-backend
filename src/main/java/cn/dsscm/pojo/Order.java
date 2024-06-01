package cn.dsscm.pojo;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Order extends AuditableEntity {
    private Integer id;
    private String serialNumber;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private Integer product;
    private BigDecimal quantity;
    private BigDecimal totalPrice;
    private Integer paymentType;
    private Integer status;
}
