package cn.dsscm.dto;

import cn.dsscm.vo.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用于传递用户查询参数的DTO
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserQuery extends BaseQuery<UserInfo> {
    private String name;
    private Integer gender;
    private Integer minAge;
    private Integer maxAge;
    private Integer role;
}
