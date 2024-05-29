package cn.dsscm.dto;

import lombok.Data;

@Data
public class LoginQuery {
    private String account;
    private String password;
    private boolean rememberMe;
}
