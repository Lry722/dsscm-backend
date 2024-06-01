package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import cn.dsscm.dto.BillQuery;
import cn.dsscm.pojo.Bill;

@Mapper
public interface BillMapper {

    List<Bill> selectList(BillQuery queryParams);

    @Delete("DELETE FROM bill WHERE id = #{id}")
    void delete(Integer id);
    
}
