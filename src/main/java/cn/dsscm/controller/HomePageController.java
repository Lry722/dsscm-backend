package cn.dsscm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dsscm.common.Result;
import cn.dsscm.service.OrderService;
import cn.dsscm.service.ProductService;
import cn.dsscm.service.ProviderService;
import cn.dsscm.vo.OverviewInfo;
import cn.dsscm.vo.SaleLast24H;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequiredArgsConstructor
@RestController
@RequestMapping
public class HomePageController {
    private final ProductService productService;
    private final ProviderService providerService;
    private final OrderService orderService;

    @GetMapping("/overview")
    public Result<OverviewInfo> overview() {
        OverviewInfo overviewInfo = new OverviewInfo();
        overviewInfo.setProductCount(productService.count());
        overviewInfo.setProviderCount(providerService.count());
        overviewInfo.setSalesToday(orderService.getSalesToday());
        overviewInfo.setSalesMonth(orderService.getSalesMonth());
        return Result.success(overviewInfo);
    }

    @GetMapping("/24h")
    public Result<List<SaleLast24H>> getSalesLast24H() {
        return Result.success(orderService.getSalesLast24H());
    }
    
}
