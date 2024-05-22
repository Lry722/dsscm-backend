package cn.dsscm.service;

import java.util.List;

import cn.dsscm.pojo.Role;

public interface RoleService {
    public List<Role> findList(String name);

    public Role findById(Integer id);

    public List<Role> findByName(String name);

    public void save(Role role);

    public void update(Role role);

    public void deleteById(Integer id);
}
