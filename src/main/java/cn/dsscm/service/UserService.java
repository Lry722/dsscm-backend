package cn.dsscm.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;
import cn.dsscm.vo.UserInfo;

public interface UserService {

    PageInfo<UserInfo> getList(UserQuery userQuery);

    UserInfo getById(Integer id);

    UserInfo getByAccount(String account);

    boolean checkPassword(String account, String password);

    void update(UserInfo userInfo, MultipartFile photo) throws IllegalStateException, IOException;

    void insert(User user, MultipartFile photo) throws IllegalStateException, IOException;

    void delete(Integer id);

    Integer count();

    String getPhotoFilename(Integer id);
}
