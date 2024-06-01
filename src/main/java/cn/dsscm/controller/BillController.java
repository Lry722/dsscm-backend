package cn.dsscm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dsscm.common.Result;
import cn.dsscm.dto.BillQuery;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.pojo.Bill;
import cn.dsscm.service.BillService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@RestController
@RequestMapping("/bills")
public class BillController {
    private final BillService billService;

    @GetMapping
    public Result<PageInfo<Bill>> getList(BillQuery queryParams) {
        return Result.success(billService.getList(queryParams));
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteBill(@PathVariable Integer id) {
        billService.delete(id);
        return Result.success();
    }
}
