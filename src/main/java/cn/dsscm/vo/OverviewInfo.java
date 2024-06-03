package cn.dsscm.vo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OverviewInfo {
    private Integer productCount;
    private Integer providerCount;
    private BigDecimal salesToday;
    private BigDecimal salesMonth;
}
