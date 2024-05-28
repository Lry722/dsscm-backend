package cn.dsscm.vo;

import java.time.LocalDate;

import lombok.Data;

/**
 * 不包含密码
 */
@Data
public class UserInfo {
    private Integer id;
    private String account;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String email;
    private String phone;
    private String address;
    private Integer role;
    private String photo;
    private String description;
}
