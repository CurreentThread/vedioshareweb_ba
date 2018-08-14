package com.vsw.service.impl;

import com.vsw.common.util.CommonUtil;
import com.vsw.domain.Collectlist;
import com.vsw.domain.Slot;
import com.vsw.domain.Vediolist;
import com.vsw.mapper.CollectlistMapper;
import com.vsw.modal.constant.SoltEnum;
import com.vsw.service.CollectService;
import com.vsw.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectlistMapper collectlistMapper;

    @Autowired
    private SlotService slotService;

    @Override
    public List<Collectlist> queryAllUserCollect(Integer userid) {
        Collectlist record = new Collectlist();
        record.setUserid(userid);
        List<Collectlist> result = collectlistMapper.select(record);
        return result;
    }

    @Override
    public Collectlist selectCertainOne(Integer userid, Integer listid) {
        Collectlist record = new Collectlist();
        record.setUserid(userid);
        record.setListid(listid);
        Collectlist result = collectlistMapper.selectOne(record);
        return result;
    }

    @Override
    public boolean collectVedioList(Vediolist vediolist,Integer userid) {
        Collectlist record = new Collectlist();
        record.setListid(vediolist.getListid());
        record.setUserid(userid);


       int flag =  collectlistMapper.insert(record);
       if(flag!=0) {
           insertSlot(vediolist, userid);
           return true;
       }
        return false;
    }

    @Override
    public boolean delCollect(Vediolist vediolist,Integer userid) {
        Collectlist record = new Collectlist();
        record.setListid(vediolist.getListid());
        record.setUserid(userid);
        int flag = collectlistMapper.delete(record);
        if(flag!=0) {
            insertSlot(vediolist, userid);
            return true;
        }
        return false;
    }

    private void insertSlot(Vediolist vediolist, Integer userid) {
        Slot slot = new Slot();
        slot.setUserid(userid);
        slot.setListname(vediolist.getListname());
        slot.setListid(vediolist.getListid());
        slot.setOpratename(SoltEnum.COLLECT.getDescribe());
        slot = CommonUtil.addCurrentTime(slot);

        slotService.addSolt(slot);
    }


    public boolean delCollectBylistid(Integer listid) {
        Collectlist record = new Collectlist();
        record.setListid(listid);
        int flag = collectlistMapper.delete(record);
        System.out.println((flag+"del"));
        if(flag!=0) {
            return true;
        }
        return false;
    }
}
