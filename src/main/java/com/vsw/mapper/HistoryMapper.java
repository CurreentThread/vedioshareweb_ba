package com.vsw.mapper;

import com.vsw.common.base.IBaseMapper;
import com.vsw.domain.History;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HistoryMapper extends IBaseMapper<History> {

    @Select("select h.* from HISTORY as h, (select max(ISVIEW) as ISVIEW ,VEDIOID ,VEDIONAME,USERID from HISTORY where USERID = #{userid} group by VEDIOID,VEDIONAME,USERID ) as t  where  h.VEDIOID= t.VEDIOID and h.USERID = t.USERID and h.ISVIEW = t.ISVIEW")
    public List<History> queryMaxView(Integer userid);
}