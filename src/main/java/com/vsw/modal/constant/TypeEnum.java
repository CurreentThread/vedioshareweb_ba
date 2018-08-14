package com.vsw.modal.constant;

public enum TypeEnum {

    /*
      状态：1-全部2-连载3-完结4-未开播
      类目：1全部2-电视剧3-电影4-动漫5-综艺
      地区：1-全部2-大陆3-台湾4-美国-5韩国6-日本7-英国8-其他
      年份：1-全部2-2018 3-2017 4-2016 5-2015-2010 6-2010-2000 7-90年代 8更早
    *
    *
    *
    * */

    ALL_TYPE(0, "全部"),
    SERIES(1, "电视剧"),
    MOVIE(2, "电影"),
    COMIC(3, "动漫"),
    PROGRAM(4, "综艺");

    private Integer code;

    private String type;

    private TypeEnum(Integer code, String type) {

        this.type = type;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
