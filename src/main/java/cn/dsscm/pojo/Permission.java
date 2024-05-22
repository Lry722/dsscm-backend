package cn.dsscm.pojo;

import java.util.BitSet;

import lombok.Data;

@Data
public class Permission {
    private Integer roleId;
    private String name;
    private Integer value;
}
