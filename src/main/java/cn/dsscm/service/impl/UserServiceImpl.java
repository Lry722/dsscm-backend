package cn.dsscm.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.dao.UserMapper;
import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;
import cn.dsscm.service.ImageService;
import cn.dsscm.service.UserService;
import cn.dsscm.vo.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final ImageService imageService;

    @Override
    public List<UserInfo> getList(UserQuery userQuery) {
        return userMapper.selectList(userQuery);
    }

    @Override
    public UserInfo getById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public UserInfo getByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    @Override
    public String selectPhoto(Integer id) {
        return userMapper.selectPhoto(id);
    }

    @Override
    public void update(UserInfo userInfo, MultipartFile photo) throws IllegalStateException, IOException {
        if (photo != null) {
            String originFilename = selectPhoto(userInfo.getId());
            if (originFilename != null) {
                imageService.delete("user-photo", originFilename);
            }
            String filename = imageService.upload("user-photo", photo);
            userInfo.setPhoto(filename);
        } else {
            userInfo.setPhoto(null);
        }
        User user = new User();
        BeanUtils.copyProperties(userInfo, user, "account", "password");
        log.info("user: {}", user);
        userMapper.update(user);
    }

    @Override
    public void insert(User user, MultipartFile photo) throws IllegalStateException, IOException {
        if (photo != null) {
            String filename = imageService.upload("user-photo", photo);
            user.setPhoto(filename);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insert(user);
    }

    @Override
    public void delete(Integer id) {
        String originFilename = selectPhoto(id);
        if (originFilename != null) {
            imageService.delete("user-photo", originFilename);
        }
        userMapper.delete(id);
    }

    @Override
    public boolean checkPassword(String account, String password) {
        String correctPassword = userMapper.selectPassword(account);
        if (passwordEncoder.matches(password, correctPassword)) {
            return true;
        } else {
            return false;
        }
    }

}
