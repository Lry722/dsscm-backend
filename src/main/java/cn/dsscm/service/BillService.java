package cn.dsscm.service;

import cn.dsscm.dto.BillQuery;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.pojo.Bill;

public interface BillService {

    PageInfo<Bill> getList(BillQuery queryParams);

    void delete(Integer id);
    
}
