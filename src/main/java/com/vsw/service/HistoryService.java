package com.vsw.service;

import com.vsw.domain.History;

import java.util.List;

public interface HistoryService {

    public List<History> queryAllbyUserid(Integer userid);


    public Integer addHistory(History history);

    public Integer updHistory(History history);

    public Integer clearAll(Integer userid);

    public List<History> queryByVedioid(Integer vedioid,Integer userid) ;


    public Integer delHistory(Integer historyid);

}
