package com.vsw.service;

import com.vsw.domain.Drama;
import com.vsw.domain.Subvedio;

import java.util.List;
import java.util.Map;

public interface SubVedioService {

    //获取指定vedio的视频列表
    public Object getAllDramas(Integer each, Integer vedioId);

    //获取vedio的最近更新的视频
    public Drama getLatestUpd();


    //获取vedio当前的集数
    public Integer getNowEpisode();

    public List<Drama> getDramas(Integer vedioId);






}
