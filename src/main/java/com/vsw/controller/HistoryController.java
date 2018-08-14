package com.vsw.controller;


import com.vsw.domain.History;
import com.vsw.domain.Testvedio;
import com.vsw.service.HistoryService;
import com.vsw.service.VedioService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private VedioService vedioService;


    @RequestMapping("/queryAll")
    public List<Object> queryAll(Integer userid) {


        List<History> allHository = historyService.queryAllbyUserid(userid);

        List<Object> vedios = new ArrayList<>();
        vedios.add(allHository);

        for (History history : allHository) {
            vedios.add(vedioService.searchContainOne(history.getVedioid()));

        }
        System.out.println(vedios);

        return vedios;
    }

    @RequestMapping("/querybyVedioid")
    public List<History> querybyVedioid(Integer userid, Integer vedioid) {


        List<History> histories = historyService.queryByVedioid(vedioid, userid);
        sortList(histories);
        return histories;


    }

    private void sortList(List<History> result) {

        Collections.sort(result, new Comparator<History>() {
            int result = 0;

            @Override
            public int compare(History o1, History o2) {
                java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date date1 = formatter.parse(o1.getHistoryd());
                    Date d2 = formatter.parse(o2.getHistoryd());
                    if (DateUtils.isSameDay(date1, d2) || date1.after(d2))
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


    @RequestMapping("addhistory")
    public Integer addHistory(History history) {


        return historyService.addHistory(history);
    }


    @RequestMapping("delhistroy")
    public Integer delHistroy(Integer historyid) {

        return historyService.delHistory(historyid);
    }

}
