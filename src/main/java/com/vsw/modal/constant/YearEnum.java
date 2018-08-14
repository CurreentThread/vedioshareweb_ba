package com.vsw.modal.constant;

public enum YearEnum {

    /*
      状态：1-全部2-连载3-完结4-未开播
      类目：1全部2-电视剧3-电影4-动漫5-综艺
      地区：1-全部2-大陆3-台湾4-美国-5韩国6-日本7-英国8-其他
      年份：1-全部2-2018 3-2017 4-2016 5-2015-2010 6-2010-2000 7-90年代 8更早
    *
    *
    *
    * */

    ALL_YEAR(0, "全部"),
    _2018(1, "2018"),
    _2017(2, "2017"),
    _2016(3, "2016"),
    _15_10(4, "2015-2010"),
    _10_00(5, "2010-2000"),
    _90(6, "90"),
    _EARLY(7, "更早");

    private Integer code;

    private String year;

    private YearEnum(Integer code, String year) {
        this.year = year;
        this.code = code;
    }

    public String getYear() {

        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
