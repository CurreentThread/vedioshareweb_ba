package com.vsw.common.util;

import com.vsw.domain.History;
import com.vsw.domain.Slot;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CommonUtil {

    //判断数组是否为空

    public static <T> boolean isEmptyArray(List<T> list) {

        boolean isEmpty = false;
        if (list == null)
            return true;

        if (list.size() == 0)
            isEmpty = true;
        if (list.size() != 0&&list.get(0) == null)
            isEmpty = true;
        return isEmpty;

    }


    public static boolean isQuaterPage(Integer page, Integer totalPage) {
        return page <= (totalPage >>2) ? true : false;
    }

    public static Slot addCurrentDay(Slot slot){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        slot.setOprateday(format.format(Calendar.getInstance().getTime()));
        return slot;
    }

    public static History addCurrentDate(History history){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        history.setHistoryd(format.format(Calendar.getInstance().getTime()));
        return history;
    }

    public static Slot addCurrentTime(Slot slot){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        slot.setOpratetime(format.format(Calendar.getInstance().getTime()));
        addCurrentDay(slot);
        return slot;
    }

}
