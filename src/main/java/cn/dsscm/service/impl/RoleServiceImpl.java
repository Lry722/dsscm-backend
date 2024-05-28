package cn.dsscm.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dsscm.dao.PermissionMapper;
import cn.dsscm.dao.RoleMapper;
import cn.dsscm.pojo.Permission;
import cn.dsscm.pojo.Role;
import cn.dsscm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Role> findList(String name) {
        List<Role> roles = roleMapper.selectList(name);
        for (Role role : roles) {
            List<Permission> permissions = permissionMapper.selectByRoleId(role.getId());
            HashMap<String, Integer> permissionsMap = new HashMap<>();
            for (Permission permission : permissions) {
                permissionsMap.put(permission.getName(), permission.getValue());
            }
            role.setPermissions(permissionsMap);
        }
        return roles;
    }

    @Override
    public Role findById(Integer id) {
        Role role = roleMapper.selectById(id);
        List<Permission> permissions = permissionMapper.selectByRoleId(id);
        HashMap<String, Integer> permissionsMap = new HashMap<>();
        for (Permission permission : permissions) {
            permissionsMap.put(permission.getName(), permission.getValue());
        }
        role.setPermissions(permissionsMap);
        return role;
    }

    @Override
    public void save(Role role) {
        roleMapper.insert(role);
        for (String permissionName : role.getPermissions().keySet()) {
            Permission permission = new Permission();
            permission.setName(permissionName);
            permission.setValue(role.getPermissions().get(permissionName));
            permission.setRoleId(role.getId());
            permissionMapper.insert(permission);
        }
    }

    @Override
    public void update(Role role) {
        roleMapper.update(role);
        for (String permissionName : role.getPermissions().keySet()) {
            Permission permission = new Permission();
            permission.setName(permissionName);
            permission.setValue(role.getPermissions().get(permissionName));
            permission.setRoleId(role.getId());
            permissionMapper.update(permission);
        }
    }

    @Override
    public List<Role> findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        roleMapper.deleteById(id);
        permissionMapper.deleteByRoleId(id);
    }

}
