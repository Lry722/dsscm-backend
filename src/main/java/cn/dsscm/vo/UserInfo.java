package cn.dsscm.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserInfo {
    private Integer id;
    private String account;
    private Integer role;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String email;
    private String phone;
    private String address;
    private String description;
}
