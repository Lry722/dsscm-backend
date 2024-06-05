package cn.dsscm.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProviderQuery;
import cn.dsscm.pojo.Provider;

public interface ProviderService {
    public PageInfo<Provider> getList(ProviderQuery queryParams);

    public void delete(Integer id);

    public List<Provider> getAllList();

    public Integer count();

    public void add(Provider provider, MultipartFile companyLicence, MultipartFile organizationCode) throws IllegalStateException, IOException;

    public void modify(Provider provider, MultipartFile companyLicence, MultipartFile organizationCode) throws IllegalStateException, IOException;

    public Provider get(Integer id);

    public byte[] getCompanyLicencePicture(Integer id) throws IOException;

    public byte[] getOrganizationCodePicture(Integer id) throws IOException;
}
