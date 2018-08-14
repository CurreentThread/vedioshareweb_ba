package com.vsw.service;

import com.vsw.domain.Vediolist;

import java.util.List;

public interface VedioListService {

    public Vediolist getCertainOne(Integer listid);


    public Vediolist createVedioList(Integer userid,String username);


    public Vediolist updateVedioList(Vediolist vediolist);


    public boolean delVediolList(Integer listid);


    public List<Vediolist> queryByUserid(Integer userid);


    public List<Vediolist> getAllVediolist();
}
