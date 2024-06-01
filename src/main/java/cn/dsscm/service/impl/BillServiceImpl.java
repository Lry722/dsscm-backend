package cn.dsscm.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import cn.dsscm.dao.BillMapper;
import cn.dsscm.dto.BillQuery;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.pojo.Bill;
import cn.dsscm.service.BillService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {
    private final BillMapper billMapper;

    @Override
    public PageInfo<Bill> getList(BillQuery queryParams) {
        Page<Bill> page = queryParams.startPage();
        billMapper.selectList(queryParams);
        return new PageInfo<>(page);
    }

    @Override
    public void delete(Integer id) {
        billMapper.delete(id);
    }
    
}
