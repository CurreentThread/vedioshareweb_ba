package com.vsw.mapper;

import com.vsw.common.base.IBaseMapper;
import com.vsw.domain.Vedio;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VedioMapper extends IBaseMapper<Vedio> {
    @Select("select * from VEDIO where VEDIONAME like #{fuzzyWord}")
    public List<Vedio> findAllByNameLike(String fuzzyWord);
}