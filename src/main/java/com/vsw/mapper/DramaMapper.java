package com.vsw.mapper;

import com.vsw.common.base.IBaseMapper;
import com.vsw.domain.Drama;
import com.vsw.domain.Subvedio;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DramaMapper extends IBaseMapper<Drama> {

    @Select("select VEDIOID,EPISODENUM,SUBVEDIONAME,ISWATCHED from DRAMA where VEDIOID= #{vedioid} group by VEDIOID,EPISODENUM,SUBVEDIONAME,ISWATCHED")
    public List<Drama> getdramas(Integer vedioid);
}