package com.vsw.controller;

import com.vsw.common.util.CommonUtil;
import com.vsw.domain.Drama;
import com.vsw.domain.Testvedio;
import com.vsw.service.SubVedioService;
import com.vsw.service.VedioService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin//跨域代理,每个controller都要写

@RequestMapping("/vedio")
public class VedioController {


    private static final Integer ORDER_BY_UPD = 1;

    private static final Integer ORDER_BY_HOT = 0;

    private static final Integer EACH_PAGE_COUNT = 12;

    private List<Testvedio> result;

    Map<Integer, List<Testvedio>> vedio_map = new HashMap<>();

    @Autowired
    private VedioService vedioService;

    @Autowired
    private SubVedioService subVedioService;


    @RequestMapping("/getAll")
    public Map<Integer, List<Testvedio>> searchAllVedios() {


        vedio_map.clear();

        result = vedioService.searchAllVedios();

        sortList(result, 0);


        if (!CommonUtil.isEmptyArray(result)) {
            vedio_map.put(result.size(), result);
        }
        return vedio_map;

    }

    @RequestMapping("/filterByCondition")
    public Map<Integer, List<Testvedio>> filterByCondition(Integer status, Integer type, Integer region, Integer year, Integer order) {

        vedio_map.clear();

        result = vedioService.searchVedioByCondition(status, type, region, year);

        sortList(result, order);

        vedio_map.put(result.size(), result);
        return vedio_map;

    }

    private void sortList(List<Testvedio> result, Integer order) {
        if (order == ORDER_BY_HOT) {
            Collections.sort(result, new Comparator<Testvedio>() {
                @Override
                public int compare(Testvedio o1, Testvedio o2) {
                    int compare = o2.getSubcribecount() - o1.getSubcribecount();
                    if (compare == 0)
                        return 0;
                    else if (compare > 0)
                        return 1;
                    else
                        return -1;
                }
            });
        } else {
            Collections.sort(result, new Comparator<Testvedio>() {
                int result = 0;

                @Override
                public int compare(Testvedio o1, Testvedio o2) {
                    java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
                    try {
                        Date d1 = formatter.parse(o1.getLatestupd());
                        Date d2 = formatter.parse(o2.getLatestupd());
                        if (DateUtils.isSameDay(d2, d1))
                            result = 0;
                        else if (d2.after(d1))
                            result = 1;
                        else
                            result = -1;

                    } catch (ParseException e) {
                        e.printStackTrace();
                    } finally {
                        return result;
                    }


                }
            });
        }


    }

    @RequestMapping("/search/{fuzzyWord}")
    public Map<Integer, List<Testvedio>> searchFuzzyWord(@PathVariable String fuzzyWord) {

        vedio_map.clear();
        List<Testvedio> result = vedioService.searchFuzzy("%" + fuzzyWord + "%");

        System.out.println(result);
        if (!CommonUtil.isEmptyArray(result))
            sortList(result, 0);


        vedio_map.put(result.size(), result);
        return vedio_map;

    }

    @RequestMapping("/searchIsNew")
    public Map<Integer, List<Testvedio>> searchIsNew(Integer type, Integer region) {

        vedio_map.clear();
        List<Testvedio> result = vedioService.searchIsNew(type, region);

        Collections.shuffle(result);

        if (!CommonUtil.isEmptyArray(result)) {
            vedio_map.put(result.size(), result);
        } else {
            vedio_map.put(0, result);
        }


        return vedio_map;
    }

    @RequestMapping("/searchIsOver")
    public Map<Integer, List<Testvedio>> searchIsOver(Integer type, Integer region) {

        vedio_map.clear();
        List<Testvedio> result = vedioService.searchIsOver(type, region);

//        sortList(result, 0);

        if (!CommonUtil.isEmptyArray(result)) {
            vedio_map.put(result.size(), result);
        } else {
            vedio_map.put(0, result);
        }
        return vedio_map;
    }


    @RequestMapping("getCertainDetail")
    public List<Object> getCertainDetail(Integer vedioId) {
        List<Object> result = new ArrayList<>();

        Testvedio result_v = vedioService.searchContainOne(vedioId);

        List<Drama> dramas = subVedioService.getDramas(vedioId);

        result.add(result_v);
        result.add(dramas);


        return result;


    }


}
