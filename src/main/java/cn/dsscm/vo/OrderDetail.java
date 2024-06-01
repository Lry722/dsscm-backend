package cn.dsscm.vo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderDetail {
    private Integer productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer quantity;
    private BigDecimal totalPrice;
}
