package com.vsw.service.impl;

import com.vsw.common.util.CommonUtil;
import com.vsw.domain.Listvedio;
import com.vsw.domain.Slot;
import com.vsw.domain.Testvedio;
import com.vsw.domain.Vediolist;
import com.vsw.mapper.ListvedioMapper;
import com.vsw.mapper.TestvedioMapper;
import com.vsw.mapper.VedioMapper;
import com.vsw.mapper.VediolistMapper;
import com.vsw.modal.constant.SoltEnum;
import com.vsw.service.ListVedioService;
import com.vsw.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListVedioServiceImpl implements ListVedioService {
    @Autowired
    private ListvedioMapper listvedioMapper;

    @Autowired
    private VediolistMapper vediolistMapper;

//    @Autowired
//    private VedioMapper vedioMapper;


    @Autowired
    private TestvedioMapper vedioMapper;

    @Autowired
    private SlotService slotService;
    @Override
    public List<Listvedio> queryByListId(Integer listid) {
        Listvedio record = new Listvedio();
        record.setListid(listid);

        List<Listvedio> result = listvedioMapper.select(record);

        return result;
    }

    @Override
    public Integer putoIntoList(Integer listid, Integer vedioid) {
        //先查找列表中是否已存在
        Listvedio listvedio = new Listvedio();
        listvedio.setListid(listid);
        listvedio.setVedioid(vedioid);


        if (listvedioMapper.selectOne(listvedio) != null) {
            return -1;

        }
        Vediolist search = new Vediolist();
        int flag = 0;
        //根据vedioid查找对应的vedio
        Testvedio vedio = vedioMapper.selectByPrimaryKey(vedioid);
        if (vedio != null) {
            System.out.println(vedio);

            //根据listid查找对应的vediolist
            search = vediolistMapper.selectByPrimaryKey(listid);
            Listvedio record = packageListVedio(listid, vedio);

            if (search != null) {
                flag = listvedioMapper.insert(record);
                if (flag != 0) {
                    //更新list的条目数
                    search.setCount(search.getCount() + 1);
                    flag = vediolistMapper.updateByPrimaryKey(search);
                }
            }
        }

        if(flag!=0){
            Slot slot = new Slot();
            slot.setUserid(search.getUserid());
            slot.setVedioid(vedioid);
            slot.setVedioname(vedio.getVedioname());
            slot.setListid(search.getListid());
            slot.setListname(search.getListname());
            slot.setOpratename(SoltEnum.ADD.getDescribe());
            slot = CommonUtil.addCurrentTime(slot);

            slotService.addSolt(slot);
        }

        return flag;
    }

    @Override
    public boolean delListVedioBylistid(Integer listid) {
        Listvedio record = new Listvedio();
        record.setListid(listid);
        int flag = listvedioMapper.delete(record);
        if (flag != 0)
            return true;
        else
            return false;
    }

    @Override
    public Integer delListVedioById(Integer listVedioid) {
        int flag = 0,listid=0;

        Listvedio search = listvedioMapper.selectByPrimaryKey(listVedioid);
        if (search != null) {
            //根据listid修改list的条目数
            Vediolist v_search = vediolistMapper.selectByPrimaryKey(search.getListid());
            if (v_search != null) {
                v_search.setCount(v_search.getCount() - 1);
                flag = vediolistMapper.updateByPrimaryKey(v_search);

                if (flag != 0) {
                    listid = listvedioMapper.selectByPrimaryKey(listVedioid).getListid();
                    flag = listvedioMapper.deleteByPrimaryKey(listVedioid);

                    if(flag!=0){
                        Slot slot = new Slot();
                        slot.setUserid(v_search.getUserid());
                        slot.setVedioid(search.getVedioid());
                        slot.setVedioname(search.getVedioname());
                        slot.setListid(v_search.getListid());
                        slot.setListname(v_search.getListname());
                        slot.setOpratename(SoltEnum.REMOVE.getDescribe());
                        slot = CommonUtil.addCurrentTime(slot);


                        slotService.addSolt(slot);
                    }
                }
            }
        }
            return listid;

    }

    private Listvedio packageListVedio(Integer listid, Testvedio vedio) {
        Listvedio record = new Listvedio();
        record.setListid(listid);
        record.setVedioid(vedio.getVedioid());
        record.setVedioname(vedio.getVedioname());
        record.setCategroy(vedio.getCatagory());
        record.setIsover(vedio.getIsover());
        record.setIsview(vedio.getIsview());
        record.setNowepisode(vedio.getNowepisode());
        record.setUpdtime(vedio.getUpdtime());
        record.setVediopicture(vedio.getPicture());
        return record;
    }


}
