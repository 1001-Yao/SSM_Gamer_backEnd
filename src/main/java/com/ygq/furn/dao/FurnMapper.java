package com.ygq.furn.dao;

import com.ygq.furn.bean.Furn;
import com.ygq.furn.bean.FurnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FurnMapper {
    long countByExample(FurnExample example);

    int deleteByExample(FurnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Furn row);

    int insertSelective(Furn row);

    List<Furn> selectByExample(FurnExample example);

    Furn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Furn row, @Param("example") FurnExample example);

    int updateByExample(@Param("row") Furn row, @Param("example") FurnExample example);

    int updateByPrimaryKeySelective(Furn row);

    int updateByPrimaryKey(Furn row);
}