package cn.dsscm.vo;

import java.math.BigDecimal;
import java.util.ArrayList;

import lombok.Data;

@Data
public class SaleLast24H {
    private String productName;
    private ArrayList<BigDecimal> data;
}
