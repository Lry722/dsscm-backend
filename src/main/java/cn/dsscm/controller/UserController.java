package cn.dsscm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.common.Result;
import cn.dsscm.dto.UserQuery;
import cn.dsscm.service.UserService;
import cn.dsscm.vo.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public Result<UserInfo> getById(@PathVariable Integer id) {
        return Result.success(userService.getById(id));
    }

    @GetMapping("/account/{account}")
    public Result<UserInfo> getByAccount(@PathVariable String account) {
        return Result.success(userService.getByAccount(account));
    }

    @GetMapping()
    public Result<List<UserInfo>> getList(UserQuery queryParam) {
        log.info(queryParam.toString());
        return Result.success(userService.getList(queryParam));
    }

    @PostMapping("/upload")
    public Result<Void> upload(@RequestParam MultipartFile file) {
        
        
        return Result.success();
    }
    
}
