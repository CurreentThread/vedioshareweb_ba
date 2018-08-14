package com.vsw.mapper;

import com.vsw.common.base.IBaseMapper;
import com.vsw.domain.Vediolist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

public interface VediolistMapper extends IBaseMapper<Vediolist> {


    @Insert("INSERT INTO VEDIOLIST(LISTNAME,COUNT,COVERIMAGE,USERID,CREATETIME,USERNAME,SUMMARY,HOT) VALUES(#{listname},#{count}, #{coverimage}, #{userid}, #{createtime}, #{username}, #{summary}, #{hot})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "listid", before = false, resultType = int.class)
    int insert(Vediolist record);

}
