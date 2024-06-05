package cn.dsscm.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;

import cn.dsscm.dao.ProviderMapper;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProviderQuery;
import cn.dsscm.pojo.Provider;
import cn.dsscm.service.ImageService;
import cn.dsscm.service.ProviderService;
import cn.dsscm.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {
    private final ProviderMapper providerMapper;
    private final ImageService imageService;

    @Override
    public PageInfo<Provider> getList(ProviderQuery queryParams) {
        Page<Provider> page = queryParams.startPage();
        providerMapper.selectList(queryParams);
        return new PageInfo<>(page);
    }

    @Override
    public void delete(Integer id) {
        providerMapper.delete(id, (Integer) ThreadLocalUtil.get("userId"));
    }

    @Override
    public List<Provider> getAllList() {
        return providerMapper.selectAll();
    }

    @Override
    public Provider get(Integer id) {
        return providerMapper.select(id);
    }

    @Override
    public Integer count() {
        return providerMapper.selectCount();
    }

    @Override
    public void add(Provider provider, MultipartFile companyLicencePicture, MultipartFile organizationCodePhoto)
            throws IllegalStateException, IOException {
        if (companyLicencePicture != null && companyLicencePicture.getContentType().equals("image/jpeg")) {
            String filename = imageService.upload("provider-company-licence", companyLicencePicture);
            provider.setCompanyLicencePicture(filename);
        }
        if (organizationCodePhoto != null && organizationCodePhoto.getContentType().equals("image/jpeg")) {
            String filename = imageService.upload("provider-organization-code", organizationCodePhoto);
            provider.setOrganizationCodePicture(filename);
        }
        provider.setCreatedBy((Integer) ThreadLocalUtil.get("userId"));
        providerMapper.insert(provider);
    }

    @Override
    public void modify(Provider provider, MultipartFile companyLicencePicture, MultipartFile organizationCodePhoto)
            throws IllegalStateException, IOException {
        String originCompanyLicencePhotoFilename = providerMapper.selectCompanyLicencePicture(provider.getId());
        if (companyLicencePicture != null) {
            if (companyLicencePicture.getContentType().equals("image/jpeg")) {
                if (originCompanyLicencePhotoFilename != null && !originCompanyLicencePhotoFilename.isEmpty()) {
                    imageService.delete("provider-company-licence", originCompanyLicencePhotoFilename);
                }
                String newFilename = imageService.upload("provider-company-licence", companyLicencePicture);
                provider.setCompanyLicencePicture(newFilename);
            }
        } else {
            if (originCompanyLicencePhotoFilename != null && !originCompanyLicencePhotoFilename.isEmpty()) {
                imageService.delete("provider-company-licence", originCompanyLicencePhotoFilename);
            }
            provider.setCompanyLicencePicture("");
        }
        String originOrganizationCodePhotoFilename = providerMapper.selectOrganizationCodePicture(provider.getId());
        if (organizationCodePhoto != null) {
            if (organizationCodePhoto.getContentType().equals("image/jpeg")) {
                if (originOrganizationCodePhotoFilename != null && !originOrganizationCodePhotoFilename.isEmpty()) {
                    imageService.delete("provider-organization-code", originOrganizationCodePhotoFilename);
                }
                String newFilename = imageService.upload("provider-organization-code", organizationCodePhoto);
                provider.setOrganizationCodePicture(newFilename);
            }
        } else {
            if (originOrganizationCodePhotoFilename != null && !originOrganizationCodePhotoFilename.isEmpty()) {
                imageService.delete("provider-organization-code", originOrganizationCodePhotoFilename);
            }
            provider.setOrganizationCodePicture("");
        }
        providerMapper.update(provider);
    }

    @Override
    public byte[] getCompanyLicencePicture(Integer id) throws IOException {
        String filename = providerMapper.selectCompanyLicencePicture(id);
        if (filename != null && !filename.isEmpty()) {
            return imageService.get("provider-company-licence",filename);
        } else {
            return imageService.get("provider-company-licence", "default.jpg");
        }
    }

    @Override
    public byte[] getOrganizationCodePicture(Integer id) throws IOException {
        String filename = providerMapper.selectOrganizationCodePicture(id);
        if (filename != null && !filename.isEmpty()) {
            return imageService.get("provider-organization-code",filename);
        } else {
            return imageService.get("provider-organization-code", "default.jpg");
        }
    }
}
