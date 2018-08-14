package com.vsw.service.impl;

import com.vsw.common.util.CommonUtil;
import com.vsw.domain.History;
import com.vsw.domain.Slot;
import com.vsw.domain.Subscribe;
import com.vsw.mapper.HistoryMapper;
import com.vsw.modal.constant.SoltEnum;
import com.vsw.service.HistoryService;
import com.vsw.service.SlotService;
import com.vsw.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private SlotService slotService;

    @Autowired
    private SubscribeService subscribeService;

    @Override
    public List<History> queryAllbyUserid(Integer userid) {

        return historyMapper.queryMaxView(userid);
    }

    @Override
    public Integer addHistory(History history) {

        System.out.println(history);
        History record1 = new History();
        record1.setUserid(history.getUserid());
        record1.setVedioid(history.getVedioid());
        record1.setIsview(history.getIsview());
        record1.setVedioname(history.getVedioname());
        if (historyMapper.selectOne(record1) != null) {

            System.out.println(33);
            return 0;
        }

        Subscribe record = subscribeService.getCertainOne(history.getVedioid(), history.getUserid());
        System.out.println(record);
        if (record != null) {

            history.setIssub(1);
        } else
            history.setIssub(0);

        Slot slot = new Slot();
        slot.setUserid(history.getUserid());
        slot.setVedioname(history.getVedioname());
        slot.setVedioid(history.getVedioid());
        slot.setOpratename(SoltEnum.WATCH.getDescribe());
        slot = CommonUtil.addCurrentTime(slot);

        slotService.addSolt(slot);

        System.out.println(history);

        history = (CommonUtil.addCurrentDate(history));
//        System.out.println(historyMapper.insert(history));

        return historyMapper.insert(history);
    }

    @Override
    public Integer updHistory(History history) {


        return historyMapper.updateByPrimaryKey(history);
    }

    @Override
    public Integer clearAll(Integer userid) {
        History record = new History();
        record.setUserid(userid);

        return historyMapper.delete(record);
    }

    @Override
    public List<History> queryByVedioid(Integer vedioid, Integer userid) {
        History record = new History();
        record.setVedioid(vedioid);

        record.setUserid(userid);
        return historyMapper.select(record);
    }


    @Override
    public Integer delHistory(Integer historyid) {
        return historyMapper.deleteByPrimaryKey(historyid);
    }
}
