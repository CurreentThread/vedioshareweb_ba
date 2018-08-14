package com.vsw.controller;

import com.vsw.domain.Subscribe;
import com.vsw.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/subscirbe")
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;





    @RequestMapping("/subsVedio")
    public Map<Integer, Subscribe> subsVedio(Integer vedioid, Integer userid) {
        Map<Integer, Subscribe> resultMap = new HashMap<>();

        Subscribe search = subscribeService.getCertainOne(vedioid, userid);
        //点击订阅或者取消订阅时要刷新listvedio的issub


        if (search == null) {
            resultMap = subscribeService.subsVedio(userid, vedioid);
        } else {
            resultMap = subscribeService.cancelSubs(search, vedioid);
        }
        return resultMap;

    }

    @RequestMapping("/cancelSub/{subid}")
    public boolean cancelSub(@PathVariable Integer subid) {

        return subscribeService.cancelSubById(subid);

    }


    @RequestMapping("/getAllSubs")
    public List<Subscribe> getsubsVedio(Integer userid) {
        List<Subscribe> results

                = subscribeService.selectAllSubs(userid);

        return results;

    }

    @RequestMapping("/selectAllView")
    public List<Subscribe> getAllsubs(Integer userid) {
        List<Subscribe> results

                = subscribeService.selectAllView(userid);

        return results;

    }


}
