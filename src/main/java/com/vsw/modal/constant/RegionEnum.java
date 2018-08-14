package com.vsw.modal.constant;

public enum RegionEnum {

    /*
      状态：1-全部2-连载3-完结4-未开播
      类目：1全部2-电视剧3-电影4-动漫5-综艺
      地区：1-全部2-大陆3-台湾4-美国-5韩国6-日本7-英国8-其他
      年份：1-全部2-2018 3-2017 4-2016 5-2015-2010 6-2010-2000 7-90年代 8更早
    *
    *
    *
    * */


    ALL_REGION(0, "全部"),
    CHINA_MAINLAND(1, "中国大陆"),
    CHINA_TAIWAN(2, "台湾"),
    AMERICA(3, "美国"),
    KOREA(4, "韩国"),
    JAPAN(5, "日本"),
    ENGLAND(6, "英国"),
    OTHER(7, "其他");
    private Integer code;

    private String region;

    private RegionEnum(Integer code, String region) {
        this.region = region;
        this.code = code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
