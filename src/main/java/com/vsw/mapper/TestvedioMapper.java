package com.vsw.mapper;

import com.vsw.common.base.IBaseMapper;
import com.vsw.domain.Testvedio;
import com.vsw.domain.Vedio;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestvedioMapper extends IBaseMapper<Testvedio> {
    @Select("select * from TESTVEDIO where VEDIONAME like #{fuzzyWord}")
    public List<Testvedio> findAllByNameLike(String fuzzyWord);
}