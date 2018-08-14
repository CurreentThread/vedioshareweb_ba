package com.vsw.controller;

import com.vsw.domain.Collectlist;
import com.vsw.domain.Listvedio;
import com.vsw.domain.Subscribe;
import com.vsw.domain.Vediolist;
import com.vsw.service.*;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/vediolist")
@Slf4j
public class VedioListController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private VedioListService vedioListService;

    @Autowired
    private ListVedioService listVedioService;


    @Autowired
    private SubscribeService subscribeService;


    @RequestMapping("/allcollect")
    public List<Vediolist> queryCollectList(Integer userid) {
        return packageVediolist(userid);
    }

    @RequestMapping("/putoIntolist")
    public Integer putoIntolist(Integer listid, Integer vedioid) {

        return listVedioService.putoIntoList(listid, vedioid);

    }



    @RequestMapping("/removeFromList")
    public Integer removeFromList(Integer listvedioid) {

        return listVedioService.delListVedioById(listvedioid);

    }

    private List<Vediolist> packageVediolist(Integer userid) {
        List<Collectlist> result = collectService.queryAllUserCollect(userid);
        System.out.println(result);
        List<Vediolist> v_result = new ArrayList<>();
        //根据listid对应全部vediolist
        for (Collectlist each : result) {
            Vediolist v_each = vedioListService.getCertainOne(each.getListid());
            if (v_each != null)
                v_result.add(v_each);
        }
        return v_result;
    }

    @RequestMapping("/getCertainOne")
    public Vediolist getCertainOne(Integer listid) {
        Vediolist result = vedioListService.getCertainOne(listid);

        return result;
    }


    @RequestMapping("/createlist")
    public Vediolist createlist(Integer userid, String listname) {

        return vedioListService.createVedioList(userid, listname);
    }


    @RequestMapping("/updatelist")
    public Vediolist updatelist(@RequestBody Vediolist vediolist) {
        return vedioListService.updateVedioList(vediolist);
    }


    @RequestMapping("/dellist")
    public boolean dellist(Integer listid) {

        //先删除相关的collect
        Collectlist record = new Collectlist();
        record.setListid(listid);
        collectService.delCollectBylistid(listid);

        //再删除该listid下的所有vedio信息
        listVedioService.delListVedioBylistid(listid);

        return vedioListService.delVediolList(listid);
    }


    @RequestMapping("/queryByUserid")
    public List<Vediolist> queryByUserid(Integer userid) {
        List<Vediolist> result = vedioListService.queryByUserid(userid);
        System.out.println("dsds" + result);
        return result;
    }

    @RequestMapping("/queryAllVedioBylistid")
    public List<Listvedio> queryAllVedioBylistid(Integer listid, Integer userid) {
        List<Listvedio> result = listVedioService.queryByListId(listid);


        //根据vedioid和userid判断这个listvedio是否被订阅
        for(Listvedio listvedio:result){
            Subscribe record = subscribeService.getCertainOne(listvedio.getVedioid(),userid);
            if(record!=null)
                listvedio.setIssub(1);
            else
                listvedio.setIssub(0);

        }

        return result;
    }


    //移除自身创建的清单
    @RequestMapping("/getAllVediolist/{userid}")
    public List<Vediolist> getAllVediolist(@PathVariable Integer userid) {

        System.out.println(userid);
        List<Vediolist> result = vedioListService.getAllVediolist();
        if (userid != -1) {
            Iterator<Vediolist> iter = result.iterator();
            while (iter.hasNext()) {
                Vediolist next = iter.next();
                if (next.getUserid() == userid)
                    iter.remove();

            }
        }
        return result;
    }

    @RequestMapping("collectVedio/{userid}")
    public Map<Integer, List<Vediolist>> collectVedio(@RequestBody Vediolist vediolist, @PathVariable Integer userid) {
        Map<Integer, List<Vediolist>> resultMap = new HashMap<>();

        int hot = vediolist.getHot();
        boolean flag = false;
        List<Vediolist> result = new ArrayList<>();
        Collectlist if_exits = collectService.selectCertainOne(userid, vediolist.getListid());
        if (if_exits != null) {
            flag = collectService.delCollect(vediolist, userid);
            hot--;
        } else {
            flag = collectService.collectVedioList(vediolist, userid);
            hot++;
        }
        vediolist.setHot(hot);
        vedioListService.updateVedioList(vediolist);


        if (flag) {
            result = packageVediolist(userid);
        }

        resultMap.put(hot, result);
        return resultMap;

    }

}
