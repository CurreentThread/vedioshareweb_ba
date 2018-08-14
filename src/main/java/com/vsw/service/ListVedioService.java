package com.vsw.service;

import com.vsw.domain.Listvedio;
import com.vsw.domain.Vedio;

import java.util.List;

public interface ListVedioService {

    public List<Listvedio> queryByListId(Integer listid);


    public Integer putoIntoList(Integer listid, Integer vedioid) ;

    public boolean delListVedioBylistid(Integer listid);

    public Integer delListVedioById(Integer listVedioid);
}
