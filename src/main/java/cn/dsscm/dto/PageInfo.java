package cn.dsscm.dto;

import java.util.ArrayList;

import com.github.pagehelper.Page;
import lombok.Data;

@Data
public class PageInfo<T> {
    public PageInfo(Page<T> page) {
        this.total = (int) page.getTotal();
        this.data = (ArrayList<T>) page.getResult();
    }

    private Integer total;
    private ArrayList<T> data;
}
