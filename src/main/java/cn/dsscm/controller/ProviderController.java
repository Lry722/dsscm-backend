package cn.dsscm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dsscm.common.Result;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProviderQuery;
import cn.dsscm.pojo.Provider;
import cn.dsscm.service.ProviderService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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

    @DeleteMapping("/{id}")
    public Result<Void> deleteProvider(@PathVariable("id") Integer id) {
        providerService.delete(id);
        return Result.success();
    }
    
}
