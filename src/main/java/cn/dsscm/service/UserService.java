package cn.dsscm.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.dto.PageQuery;
import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;
import cn.dsscm.vo.UserInfo;

public interface UserService {

    List<UserInfo> getList(UserQuery userQuery, PageQuery pageQuery);

    UserInfo getById(Integer id);

    UserInfo getByAccount(String account);

    String selectPhoto(Integer id);

    boolean checkPassword(String account, String password);

    void update(UserInfo userInfo, MultipartFile photo) throws IllegalStateException, IOException;

    void insert(User user, MultipartFile photo) throws IllegalStateException, IOException;

    void delete(Integer id);

    Integer count();

    String getPhotoFilename(Integer id);
}
