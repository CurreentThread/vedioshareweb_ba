package com.vsw.controller;

import com.vsw.domain.Slot;
import com.vsw.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/slot")
public class SlotController {

    @Autowired
    private SlotService slotService;


    @RequestMapping("/delByid")
    public Integer delByid(Integer slotid) {
        return slotService.delSoltByid(slotid);
    }

    @RequestMapping("/delAll")
    public Integer delAll(Integer userid) {
        return slotService.delAll(userid);
    }


    @RequestMapping("/queryall")
    public Map<List<String>, List<Slot>> queryAll(Integer userid) {
        List<String> days = new ArrayList<>();

        List<Slot> slots = slotService.queryAllSlotsByUserid(userid);
        Iterator<Slot> iter = slots.iterator();
        while (iter.hasNext()) {
            Slot slot = iter.next();
            if (!days.contains(slot.getOprateday())) {
                days.add(slot.getOprateday());
                System.out.println(days);
            }
        }
        Map<List<String>, List<Slot>> map = new HashMap<>();
        map.put(days, slots);

        return map;


    }

}
