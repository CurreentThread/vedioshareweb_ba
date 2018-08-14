package com.vsw.service.impl;

import com.vsw.domain.Slot;
import com.vsw.mapper.SlotMapper;
import com.vsw.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class SoltServiceImpl implements SlotService {
    @Autowired
    private SlotMapper slotMapper;

    @Override
    public List<Slot> queryAllSlotsByUserid(Integer userid) {

        Slot record = new Slot();
        record.setUserid(userid);

        List<Slot> slots = slotMapper.select(record);


        return slots;
    }

    @Override
    public Integer addSolt(Slot slot) {

        return slotMapper.insert(slot);
    }

    @Override
    public Integer delSoltByid(Integer soltid) {

        return slotMapper.deleteByPrimaryKey(soltid);
    }

    @Override
    public Integer delAll(Integer userid) {
        Slot record = new Slot();
        record.setUserid(userid);

        return slotMapper.delete(record);
    }
}
