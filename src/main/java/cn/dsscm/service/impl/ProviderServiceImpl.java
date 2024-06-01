package cn.dsscm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import cn.dsscm.dao.ProviderMapper;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProviderQuery;
import cn.dsscm.pojo.Provider;
import cn.dsscm.service.ProviderService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {
    private final ProviderMapper providerMapper;

    @Override
    public PageInfo<Provider> getList(ProviderQuery queryParams) {
        Page<Provider> page = queryParams.startPage();
        providerMapper.selectList(queryParams);
        return new PageInfo<>(page);
    }

    @Override
    public void delete(Integer id) {
        providerMapper.delete(id);
    }

    @Override
    public List<Provider> getAllList() {
        return providerMapper.selectAll();
    }
}
