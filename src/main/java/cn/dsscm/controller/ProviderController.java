package cn.dsscm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.common.Result;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProviderQuery;
import cn.dsscm.pojo.Provider;
import cn.dsscm.service.ProviderService;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;

@RequiredArgsConstructor
@RestController
@RequestMapping("/providers")
public class ProviderController {
    private final ProviderService providerService;

    @GetMapping("/list")
    public Result<List<Provider>> getAllProviderList() {
        return Result.success(providerService.getAllList());
    }

    @GetMapping
    public Result<PageInfo<Provider>> queryProviderList(ProviderQuery queryParams) {
        return Result.success(providerService.getList(queryParams));
    }

    @GetMapping("/{id}")
    public Result<Provider> getProvider(@PathVariable Integer id) {
        return Result.success(providerService.get(id));
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteProvider(@PathVariable("id") Integer id) {
        providerService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result<Void> addProvider(@RequestPart("provider") Provider provider,
            @RequestPart("companyLicencePicture") MultipartFile companyLicencePicture,
            @RequestPart("organizationCodePicture") MultipartFile organizationCodePicture)
            throws IllegalStateException, IOException {
        providerService.add(provider, companyLicencePicture, organizationCodePicture);
        return Result.success();
    }

    @PutMapping
    public Result<Void> modifyProvider(@RequestPart("provider") Provider provider,
            @RequestPart("companyLicencePicture") MultipartFile companyLicencePicture,
            @RequestPart("organizationCodePicture") MultipartFile organizationCodePicture)
            throws IllegalStateException, IOException {
        providerService.modify(provider, companyLicencePicture, organizationCodePicture);
        return Result.success();
    }

    @GetMapping("/companyLicencePicture/{id}")
    public byte[] getCompanyLicencePicture(@PathVariable Integer id) throws IOException {
        return providerService.getCompanyLicencePicture(id);
    }


    @GetMapping("/organizationCodePicture/{id}")
    public byte[] getOrganizationCodePicture(@PathVariable Integer id) throws IOException {
        return providerService.getOrganizationCodePicture(id);
    }
    
}
