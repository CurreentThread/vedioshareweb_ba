package com.vsw.service.impl;

import com.vsw.common.util.CommonUtil;
import com.vsw.domain.*;
import com.vsw.mapper.ListvedioMapper;
import com.vsw.mapper.SubscribeMapper;
import com.vsw.mapper.TestvedioMapper;
import com.vsw.mapper.VedioMapper;
import com.vsw.modal.constant.SoltEnum;
import com.vsw.service.HistoryService;
import com.vsw.service.SlotService;
import com.vsw.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private SubscribeMapper subscribeMapper;

    @Autowired
    private TestvedioMapper vedioMapper;

    @Autowired
    private ListvedioMapper listvedioMapper;

    @Autowired
    private SlotService slotService;


    @Autowired
    private HistoryService historyService;

    private List<Listvedio> findIfExits(Integer vedioid) {
        Listvedio record = new Listvedio();
        record.setVedioid(vedioid);
        List<Listvedio> find = listvedioMapper.select(record);
        return find;
    }

    @Override
    public Map<Integer, Subscribe> subsVedio(Integer userid, Integer vedioid) {


        Subscribe record = new Subscribe();
        record.setUserid(userid);
        Testvedio v_result
                = vedioMapper.selectByPrimaryKey(vedioid);

        return packageVedio(vedioid, record, v_result);

    }


    private Map<Integer, Subscribe> packageVedio(Integer vedioid, Subscribe record, Testvedio v_result) {
        Map<Integer, Subscribe> resultMap = new HashMap<>();

        if (v_result != null) {
            record.setVedioid(vedioid);
            record.setCategory(v_result.getCatagory());
            record.setIsview(0);
            record.setNowepisode(v_result.getNowepisode());
            record.setUpdtime(v_result.getUpdtime());
            record.setPicture(v_result.getPicture());

            record.setVedioname(v_result.getVedioname());
            record.setIsnew(v_result.getIsnew());
            int subs_result = subscribeMapper.insert(record);
            v_result.setSubcribecount(v_result.getSubcribecount() + 1);
            int update_v = vedioMapper.updateByPrimaryKey(v_result);
            System.out.println((subs_result));
            if (subs_result != 0 && update_v != 0) {
                resultMap.put(v_result.getSubcribecount(), subscribeMapper.selectOne(record));

                //添加足迹
                Slot slot = new Slot();
                slot.setUserid(record.getUserid());
                slot.setVedioid(vedioid);
                slot.setVedioname(v_result.getVedioname());
                slot.setOpratename(SoltEnum.SUBSCRIBE.getDescribe());
                slot = CommonUtil.addCurrentTime(slot);

               List<History>  historys = historyService.queryByVedioid(vedioid, record.getUserid());
                if(!CommonUtil.isEmptyArray(historys)){
                    for(History history:historys){
                        history.setIssub(1);
                        historyService.updHistory(history);
                    }
                }

                slotService.addSolt(slot);

            }
        }
        return resultMap;
    }

    @Override
    public List<Subscribe> selectAllSubs(Integer userid) {
        Subscribe record = new Subscribe();
        record.setUserid(userid);
        List<Subscribe> result = subscribeMapper.select(record);

        return result;
    }

    @Override
    public List<Subscribe> selectAllView(Integer userid) {
        Subscribe record = new Subscribe();
        record.setUserid(userid);
        List<Subscribe> result = subscribeMapper.select(record);

        return result;
    }

    @Override
    public Map<Integer, Subscribe> cancelSubs(Subscribe subscribe, Integer vedioid) {


        Map<Integer, Subscribe> resultMap = new HashMap<>();

        int delete = subscribeMapper.deleteByPrimaryKey(subscribe.getSubid());
        Testvedio vedio = vedioMapper.selectByPrimaryKey(vedioid);
        vedio.setSubcribecount(vedio.getSubcribecount() - 1);
        int update = vedioMapper.updateByPrimaryKey(vedio);
        if (delete != 0 && update != 0) {
            resultMap.put(vedio.getSubcribecount(), subscribe);
            //添加足迹
            Slot slot = new Slot();
            slot.setUserid(subscribe.getUserid());
            slot.setVedioid(vedioid);
            slot.setVedioname(subscribe.getVedioname());
            slot.setOpratename(SoltEnum.CANCEL.getDescribe() + SoltEnum.SUBSCRIBE.getDescribe());
            slot = CommonUtil.addCurrentTime(slot);



            List<History>  historys = historyService.queryByVedioid(vedioid, subscribe.getUserid());
            if(!CommonUtil.isEmptyArray(historys)){
                for(History history:historys){
                    history.setIssub(0);
                    historyService.updHistory(history);
                }
            }
            slotService.addSolt(slot);
        }
        return resultMap;
    }

    @Override
    public boolean cancelSubById(Integer sudid) {
        Subscribe search = subscribeMapper.selectByPrimaryKey(sudid);


        if (search != null) {
            int vedioid = search.getVedioid();
            Testvedio record = vedioMapper.selectByPrimaryKey(vedioid);
            System.out.println((record));
            if (record != null) {
                record.setSubcribecount(record.getSubcribecount() - 1);
            }
            System.out.println((record));
            vedioMapper.updateByPrimaryKey(record);
        }


        int flag = subscribeMapper.deleteByPrimaryKey(sudid);
        if (flag != 0) {
            //添加足迹
            Slot slot = new Slot();
            slot.setUserid(search.getUserid());
            slot.setVedioid(search.getVedioid());
            slot.setVedioname(search.getVedioname());
            slot.setOpratename(SoltEnum.CANCEL.getDescribe() + SoltEnum.SUBSCRIBE.getDescribe());
            slot = CommonUtil.addCurrentTime(slot);


            List<History>  historys = historyService.queryByVedioid(search.getVedioid(), search.getUserid());
            if(!CommonUtil.isEmptyArray(historys)){
                for(History history:historys){
                    history.setIssub(0);
                    historyService.updHistory(history);
                }
            }

            slotService.addSolt(slot);
            return true;
        } else
            return false;
    }

    @Override
    public Subscribe getCertainOne(Integer vedioid, Integer userid) {
        Subscribe record = new Subscribe();
        record.setVedioid(vedioid);
        record.setUserid(userid);
        Subscribe search = subscribeMapper.selectOne(record);

        return search;
    }
}
