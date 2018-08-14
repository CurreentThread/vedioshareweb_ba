package com.vsw.service;

import com.vsw.domain.Subscribe;
import com.vsw.domain.Vedio;

import java.util.List;
import java.util.Map;

public interface SubscribeService {

    public Map<Integer, Subscribe> subsVedio(Integer userid, Integer vedioid);

    public List<Subscribe> selectAllSubs(Integer userid);

    public List<Subscribe> selectAllView(Integer userid);


    public Map<Integer, Subscribe> cancelSubs(Subscribe subscribe, Integer vedioid);

    public boolean cancelSubById(Integer sudid);


    public Subscribe getCertainOne(Integer vedioid, Integer userid);
}
