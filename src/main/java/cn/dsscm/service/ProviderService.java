package cn.dsscm.service;

import java.util.List;

import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProviderQuery;
import cn.dsscm.pojo.Provider;

public interface ProviderService {
    public PageInfo<Provider> getList(ProviderQuery queryParams);

    public void delete(Integer id);

    public List<Provider> getAllList();

    public Integer count();
}
