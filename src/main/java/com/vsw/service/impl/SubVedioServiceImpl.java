package com.vsw.service.impl;

import com.vsw.domain.Drama;
import com.vsw.mapper.DramaMapper;
import com.vsw.mapper.SubvedioMapper;
import com.vsw.service.SubVedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@CacheConfig
public class SubVedioServiceImpl implements SubVedioService {

    //每一页12条
    private static final Integer EACH_PAGE_COUNT = 7;

    @Autowired
    private DramaMapper subvedioMapper;

    @Override
    @Cacheable(value = "drama",key = "#vedioid")

    public Object getAllDramas(Integer each, Integer vedioId) {

//        List<Subvedio> sub_map = new ArrayList<>();
        Drama record = new Drama();
        record.setEpisodenum(each);
        record.setVedioid(vedioId);
        List<Drama> subVedios = subvedioMapper.select(record);


        return subVedios;
    }

    @Override
    public Drama getLatestUpd() {


        return null;
    }

    @Override
    public Integer getNowEpisode() {
        return null;
    }

    @Override
    public List<Drama> getDramas(Integer vedioId) {
        return subvedioMapper.getdramas(vedioId);
    }
}
