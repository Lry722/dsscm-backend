package cn.dsscm.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderDetails {
    private String serialNumber;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private BigDecimal count;
    private BigDecimal totalPrice;
    private Integer paymentType;
    private Integer status;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime creationTime;
    private List<OrderDetail> details;
}
