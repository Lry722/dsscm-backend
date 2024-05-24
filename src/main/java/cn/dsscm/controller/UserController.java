package cn.dsscm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;
import cn.dsscm.service.UserService;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public List<User> getList() {
        UserQuery userQuery = new UserQuery();
        return userService.getList(userQuery);
    }
    

}
