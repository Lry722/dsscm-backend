package cn.dsscm.pojo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String account;
    private String password;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String email;
    private String phone;
    private String address;
    private String description;
    
}
