package cn.dsscm.dto;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.Data;

@Data
public class PageQuery {
    private Integer pageNum;
    private Integer pageSize;

    public Page<Object> startPage() {
        return PageHelper.startPage(pageNum, pageSize);
    }
}
