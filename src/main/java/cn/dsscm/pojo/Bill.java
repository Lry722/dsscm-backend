package cn.dsscm.pojo;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Bill extends AuditableEntity{
    private Integer id;
    private String code;
    private Integer product;
    private BigDecimal quantity;
    private BigDecimal totalPrice;
    private Boolean paid;
    private Integer provider;
}
