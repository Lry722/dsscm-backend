package cn.dsscm.dto;

import cn.dsscm.pojo.Bill;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BillQuery extends BaseQuery<Bill> {
    Integer product;
    Integer provider;
    Boolean paid;
}
