package com.vsw.mapper;

import com.vsw.common.base.IBaseMapper;
import com.vsw.domain.Subvedio;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SubvedioMapper extends IBaseMapper<Subvedio> {

    @Select("select VEDIOID,EPISODENUM,SUBVEDIONAME,ISWATCHED from SUBVEDIO where VEDIOID= #{vedioid} group by VEDIOID,EPISODENUM,SUBVEDIONAME,ISWATCHED")
    public List<Subvedio> getdramas(Integer vedioid);
}