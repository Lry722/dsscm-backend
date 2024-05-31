package cn.dsscm.dto;

import java.time.LocalDateTime;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.Data;

@Data
public abstract class BaseQuery<T> {
    // 审计查询字段
    private Integer createdBy;
    private LocalDateTime minCreationTime;
    private LocalDateTime maxCreationTime;
    private Integer modifiedBy;
    private LocalDateTime minModificationTime;
    private LocalDateTime maxModificationTime;

    // 分页查询字段
    private Integer pageNum;
    private Integer pageSize;

    public Page<T> startPage() {
        return PageHelper.startPage(pageNum, pageSize);
    }
}
