package cn.dsscm.dto;

import cn.dsscm.common.enums.Gender;
import lombok.Data;

/**
 * 用于传递用户查询参数的DTO
 */
@Data
public class UserQuery {
    private String name;
    private Gender gender;
    private Integer minAge;
    private Integer maxAge;
    private Integer role;
}
