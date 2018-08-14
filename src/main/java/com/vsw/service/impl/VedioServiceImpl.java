package com.vsw.service.impl;

//import com.vsw.common.base.VedioRepository;

import com.vsw.common.util.CommonUtil;
import com.vsw.common.util.GlobalExcetion;
import com.vsw.domain.Testvedio;
import com.vsw.mapper.TestvedioMapper;
import com.vsw.mapper.VedioMapper;
import com.vsw.modal.constant.RegionEnum;
import com.vsw.modal.constant.StatusEnum;
import com.vsw.modal.constant.TypeEnum;
import com.vsw.modal.constant.YearEnum;
import com.vsw.service.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;

@Service
public class VedioServiceImpl implements VedioService {


    //每一页12条
    private static final Integer EACH_PAGE_COUNT = 12;


    @Autowired
    private TestvedioMapper vedioMapper;
//
//
//    @Autowired
//    private VedioRepository  vedioRepository;

//    private List<Vedio> vedios;

    @Override
    public List<Testvedio> searchAllVedios() {
        //当首次加载页面时，会返回前半部分数据

        List<Testvedio> vedios = vedioMapper.selectAll();
        return vedios;
    }

    @Override
    public Testvedio searchContainOne(Integer vedioid) {

        Testvedio result = null;
        result = vedioMapper.selectByPrimaryKey(vedioid);

        return result;
    }


    //类目、地区、上映年份、状态
    @Override
    public List<Testvedio> searchVedioByCondition(Integer status, Integer type, Integer region, Integer year) {
        List<Testvedio> result_vedios = vedioMapper.selectAll();


        Testvedio record = new Testvedio();
        if (status != StatusEnum.ALL_SATUS.getStatus()) {
            record.setIsover(status);
        }
        if (type != TypeEnum.ALL_TYPE.getCode()) {
            record = setCatagory(record, type);
        }
        if (region != RegionEnum.ALL_REGION.getCode()) {
            record = setRegion(record, region);
        }
//        System.out.println(record);
        result_vedios = vedioMapper.select(record);

        if (year != YearEnum.ALL_YEAR.getCode()) {
            Iterator<Testvedio> iter = result_vedios.iterator();
            while (iter.hasNext()) {
                Testvedio next = iter.next();
                if (!judgeIsInYear(next, year))
                    iter.remove();
            }
        }
        return result_vedios;
    }

    private boolean judgeIsInYear(Testvedio next, Integer year) {
        boolean isInYear = false;
        String time = next.getTime();

        if (time == null)
            return isInYear;
        switch (year) {
            case 1:
                if (StringUtils.pathEquals(time, YearEnum._2018.getYear())) {
                    isInYear = true;
                }
                break;
            case 2:
                if (StringUtils.pathEquals(time, YearEnum._2017.getYear())) {
                    isInYear = true;
                }
                break;
            case 3:
                if (StringUtils.pathEquals(time, YearEnum._2016.getYear())) {
                    isInYear = true;
                }
                break;
            case 4:
                if (Integer.parseInt(time) <= 2015 && Integer.parseInt(time) > 2010) {
                    isInYear = true;
                }
                break;
            case 5:
                if (Integer.parseInt(time) <= 2010 && Integer.parseInt(time) > 2000) {
                    isInYear = true;
                }
                break;
            case 6:
                if (Integer.parseInt(time) <= 2000 && Integer.parseInt(time) > 1990) {
                    isInYear = true;
                }
                break;
            case 7:
                if (Integer.parseInt(time) <= 1990) {
                    isInYear = true;
                }
                break;

        }


        return isInYear;
    }


    private Testvedio setRegion(Testvedio record, Integer region) {
        if (region == RegionEnum.CHINA_MAINLAND.getCode()) {
            record.setRegion(RegionEnum.CHINA_MAINLAND.getRegion());
        } else if (region == RegionEnum.CHINA_TAIWAN.getCode()) {
            record.setRegion(RegionEnum.CHINA_TAIWAN.getRegion());
        } else if (region == RegionEnum.AMERICA.getCode()) {
            record.setRegion(RegionEnum.AMERICA.getRegion());
        } else if (region == RegionEnum.KOREA.getCode()) {
            record.setRegion(RegionEnum.KOREA.getRegion());
        } else if (region == RegionEnum.JAPAN.getCode()) {
            record.setRegion(RegionEnum.JAPAN.getRegion());
        } else if (region == RegionEnum.ENGLAND.getCode()) {
            record.setRegion(RegionEnum.ENGLAND.getRegion());
        } else if (region == RegionEnum.OTHER.getCode()) {
            record.setRegion(RegionEnum.OTHER.getRegion());
        }

        return record;
    }

    private Testvedio setCatagory(Testvedio record, Integer type) {
        if (type == TypeEnum.SERIES.getCode()) {
            record.setCatagory(TypeEnum.SERIES.getType());
        } else if (type == TypeEnum.MOVIE.getCode()) {
            record.setCatagory(TypeEnum.MOVIE.getType());
        } else if (type == TypeEnum.COMIC.getCode()) {
            record.setCatagory(TypeEnum.COMIC.getType());
        } else if (type == TypeEnum.PROGRAM.getCode()) {
            record.setCatagory(TypeEnum.PROGRAM.getType());
        }

        return record;
    }

    @Override
    public List<Testvedio> searchFuzzy(String fuzzyWord) {

        List<Testvedio> result_vedios = vedioMapper.findAllByNameLike(fuzzyWord);

        return result_vedios;
    }

    @Override
    public List<Testvedio> searchIsNew(Integer type,Integer region) {

        Testvedio record = new Testvedio();
        record = setCatagory(record, type);

        record = setRegion(record,region);

        record.setIsnew(1);

        List<Testvedio> result_vedios = vedioMapper.select(record);

        return result_vedios;
    }

    @Override
    public List<Testvedio> searchLatestUpd() {


        return null;
    }

    @Override
    public List<Testvedio> searchIsOver(Integer type,Integer region) {

        Testvedio record = new Testvedio();
        record = setCatagory(record, type);

        record = setRegion(record,region);
        record.setIsover(1);
        List<Testvedio> result_vedios = vedioMapper.select(record);

        return result_vedios;
    }

//    @Override
//    public boolean addSubsCount(Integer vedioid) {
//
//        Vedio certainOne = vedioMapper.selectByPrimaryKey(vedioid);
//        if (certainOne != null) {
//            certainOne.setSubcribecount(certainOne.getSubcribecount() + 1);
//            vedioMapper.updateByPrimaryKey(certainOne);
//            return true;
//        }
//        return false;
//    }


}
