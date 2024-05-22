package cn.dsscm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.dsscm.common.Result;
import cn.dsscm.pojo.Role;
import cn.dsscm.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping()
    public Result<List<Role>> getList(@RequestParam(required = false) String name) {
        return Result.success(roleService.findList(name));
    }

    @PostMapping()
    public Result<Void> add(@RequestBody Role role) {
        roleService.save(role);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        roleService.deleteById(id);
        return Result.success();
    }

    @PutMapping()
    public Result<Void> edit(@RequestBody Role role) {
        roleService.update(role);
        return Result.success();
    }

}
