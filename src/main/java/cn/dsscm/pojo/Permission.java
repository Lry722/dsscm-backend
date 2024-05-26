package cn.dsscm.pojo;

import lombok.Data;

@Data
public class Permission {
    private Integer roleId;
    private String name;
    private Integer value;
}
