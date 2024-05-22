package cn.dsscm.pojo;

import java.util.ArrayList;
import java.util.HashMap;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Role {
    @NotNull
    private Integer id;
    @NotEmpty
    private String name;

    private HashMap<String, Integer> permissions;
}
