package cn.dsscm.pojo;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class User {
    private Integer id;

    @NotBlank
    private String account;

    @NotBlank
    @Size(min = 6, max = 16)
    private String password;

    @NotBlank
    @Size(min = 2, max = 16)
    private String name;
    private String gender;

    private LocalDate birthday;
    private String email;
    private String phone;
    private String address;

    @NotNull
    private Integer role;
    private String photo;
    private String description;
}
