package com.vsw.service.impl;

import com.vsw.common.util.CommonUtil;
import com.vsw.domain.Collectlist;
import com.vsw.domain.Slot;
import com.vsw.domain.Vediolist;
import com.vsw.domain.Vediouser;
import com.vsw.mapper.VediolistMapper;
import com.vsw.mapper.VediouserMapper;
import com.vsw.modal.constant.SoltEnum;
import com.vsw.service.SlotService;
import com.vsw.service.VedioListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class VedioListServiceImpl implements VedioListService {
    @Autowired
    private VediolistMapper vediolistMapper;

    @Autowired
    private VediouserMapper vediouserMapper;

    @Autowired
    private SlotService slotService;

    @Override
    public Vediolist getCertainOne(Integer listid) {
        Vediolist result = vediolistMapper.selectByPrimaryKey(listid);
        return result;
    }

    @Override
    public Vediolist createVedioList(Integer userid, String listname) {
        Vediolist record = new Vediolist();
        record.setUserid(userid);
        Vediouser user = vediouserMapper.selectByPrimaryKey(userid);
        if(user!=null){
            record.setUsername(user.getUsername());
        }
        record.setListname(listname);
        record.setCoverimage("../static/cover/default.jpg");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.format(Calendar.getInstance().getTime());
        record.setCount(0);
        record.setHot(0);

        record.setCreatetime(format.format(Calendar.getInstance().getTime()));
        int flag = vediolistMapper.insert(record);


//        Vediolist returnback = vediolistMapper.select(record).;
        if (flag != 0) {

            //添加足迹
            Slot slot = new Slot();
            slot.setUserid(userid);
            slot.setListname(listname);
            slot.setListid(record.getListid());
            slot.setOpratename(SoltEnum.ADD.getDescribe());
            slot = CommonUtil.addCurrentTime(slot);


            slotService.addSolt(slot);
            return record;
        }
        else
            return null;
    }

    @Override
    public Vediolist updateVedioList(Vediolist vediolist) {

        int flag = vediolistMapper.updateByPrimaryKey(vediolist);

        if (flag != 0) {
            Slot slot = new Slot();
            slot.setUserid(vediolist.getUserid());
            slot.setListname(vediolist.getListname());
            slot.setListid(vediolist.getListid());
            slot.setOpratename(SoltEnum.UPDATE.getDescribe());
            slot = CommonUtil.addCurrentTime(slot);


            slotService.addSolt(slot);
            return vediolist;
        }
        else
            return null;

    }

    @Override
    public boolean delVediolList(Integer listid) {

        Vediolist find = vediolistMapper.selectByPrimaryKey(listid);

        int flag = vediolistMapper.deleteByPrimaryKey(listid);

        if (flag != 0) {
            Slot slot = new Slot();
            slot.setUserid(find.getUserid());
            slot.setListname(find.getListname());
            slot.setListid(listid);
            slot.setOpratename(SoltEnum.DELETE.getDescribe());
            slot = CommonUtil.addCurrentTime(slot);

            slotService.addSolt(slot);
            return true;
        }
        else
            return false;
    }

    @Override
    public List<Vediolist> queryByUserid(Integer userid) {
        Vediolist record = new Vediolist();
        record.setUserid(userid);
        List<Vediolist> result = vediolistMapper.select(record);

        return result;
    }

    @Override
    public List<Vediolist> getAllVediolist() {
        List<Vediolist> result = vediolistMapper.selectAll();
        return result;
    }
}
