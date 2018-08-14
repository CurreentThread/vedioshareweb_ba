package com.vsw.service;

import com.vsw.domain.Slot;

import java.util.List;

public interface SlotService {

    public List<Slot> queryAllSlotsByUserid(Integer userid);

    public Integer addSolt(Slot slot);

    public Integer delSoltByid(Integer soltid);

    public Integer delAll(Integer userid);

}
