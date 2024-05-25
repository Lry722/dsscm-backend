package cn.dsscm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;
import cn.dsscm.service.UserService;
import cn.dsscm.vo.UserInfo;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserInfo getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/account/{account}")
    public UserInfo getByAccount(@PathVariable String account) {
        return userService.getByAccount(account);
    }

    @GetMapping()
    public List<UserInfo> getList(@RequestParam UserQuery userQuery) {
        return userService.getList(userQuery);
    }
}
