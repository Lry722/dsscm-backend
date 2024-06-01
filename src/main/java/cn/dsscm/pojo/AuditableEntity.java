package cn.dsscm.pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public abstract class AuditableEntity {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime creationTime;
    private Integer createdBy;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime modificationTime;
    private Integer modifiedBy;

    public void setCreatedBy(Integer userId) {
        createdBy = userId;
        if (modifiedBy == null) {
            modifiedBy = userId;
        }
    }
}
