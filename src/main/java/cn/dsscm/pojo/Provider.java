package cn.dsscm.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Provider extends AuditableEntity {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private String contact;
    private String phone;
    private String address;
    private String fax;
    private String companyLicencePicture;
    private String organizationCodePicture;
}
