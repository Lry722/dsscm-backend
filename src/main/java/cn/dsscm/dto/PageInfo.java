package cn.dsscm.dto;

import java.util.ArrayList;

import com.github.pagehelper.Page;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageInfo<T> {
    public PageInfo(Page<T> page) {
        this.total = (Long) page.getTotal();
        this.data = (ArrayList<T>) page.getResult();
    }

    private Long total;
    private ArrayList<T> data;
}
