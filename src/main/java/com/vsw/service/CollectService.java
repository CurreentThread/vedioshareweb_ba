package com.vsw.service;

import com.vsw.domain.Collectlist;
import com.vsw.domain.Vediolist;

import java.util.List;

public interface CollectService {

    public List<Collectlist> queryAllUserCollect(Integer userid);

    public Collectlist selectCertainOne(Integer userid, Integer listid);


    public boolean collectVedioList(Vediolist vediolist, Integer userid);

    public boolean delCollect(Vediolist vediolist, Integer userid);

    public boolean delCollectBylistid(Integer listid);


}
