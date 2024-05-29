package cn.dsscm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.common.Result;
import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;
import cn.dsscm.service.ImageService;
import cn.dsscm.service.UserService;
import cn.dsscm.vo.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ImageService imageService;

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
        return Result.success(userService.getList(queryParam));
    }

    @PostMapping()
    public Result<Void> add(@RequestPart User user, @RequestPart(required = false) MultipartFile photo) throws IllegalStateException, IOException {
        userService.insert(user, photo);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return Result.success();
    }

    @PutMapping()
    public Result<Void> modify(@RequestPart UserInfo userInfo, @RequestPart(required = false) MultipartFile photo) throws IllegalStateException, IOException {
        userService.update(userInfo, photo);
        return Result.success();
    }

    @GetMapping("/photo/{filename}")
    public byte[] getMethodName(@PathVariable String filename) throws IOException {
        return imageService.get("user-photo", filename);
    }
}
