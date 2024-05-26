package cn.dsscm.pojo;

import java.util.Map;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Role {
    @NotNull
    private Integer id;
    @NotEmpty
    private String name;

    private Map<String, Integer> permissions;
}
