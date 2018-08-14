package com.vsw.service;

import com.vsw.domain.Testvedio;
import com.vsw.domain.Vedio;

import java.util.List;

public interface VedioService {

    //所有查询均按订阅数降序排序

    //分页
    public List<Testvedio> searchAllVedios();


    public Testvedio searchContainOne(Integer vedioid);


    //根据地区、类型、类目查找
    public List<Testvedio> searchVedioByCondition(Integer status, Integer type, Integer region, Integer year);


    //模糊查找
    public List<Testvedio> searchFuzzy(String vedioname);


    //查找最近上新的vedio,取前30个
    public List<Testvedio> searchIsNew(Integer type,Integer region) ;


    //查找最近更新,会取前30个,随机获取
    public List<Testvedio> searchLatestUpd();

    //查找完结剧集,会取前30个,随机获取
    public List<Testvedio> searchIsOver(Integer type,Integer region);


//    public boolean addSubsCount(Integer vedioid);


}
