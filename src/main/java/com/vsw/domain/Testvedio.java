package com.vsw.domain;

import java.io.Serializable;
import javax.persistence.*;

public class Testvedio implements Serializable {
    @Id
    @Column(name = "VEDIOID")
    private Integer vedioid;

    @Column(name = "UPDTIME")
    private String updtime;

    @Column(name = "PICTURE")
    private String picture;

    @Column(name = "SUBNAME")
    private String subname;

    /**
     * 1-电视剧2-电影3-动漫4-综艺1-电视剧2-电影3-动漫4-综艺5-其他
     */
    @Column(name = "CATAGORY")
    private String catagory;

    /**
     * 1-中国2-美国-3韩国-4英国-5-日本6-其他
     */
    @Column(name = "REGION")
    private String region;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "EPISODE")
    private Integer episode;

    @Column(name = "NOWEPISODE")
    private Integer nowepisode;

    /**
     * 0连载-1完结-2未开播
     */
    @Column(name = "ISOVER")
    private Integer isover;

    @Column(name = "TIME")
    private String time;

    @Column(name = "LATESTUPD")
    private String latestupd;

    /**
     * 0新剧-1非新剧
     */
    @Column(name = "ISNEW")
    private Integer isnew;

    @Column(name = "SUBCRIBECOUNT")
    private Integer subcribecount;

    @Column(name = "VEDIONAME")
    private String vedioname;

    @Column(name = "DIRECTOR")
    private String director;

    /**
     * 主演
     */
    @Column(name = "ACTOR")
    private String actor;

    @Column(name = "ISVIEW")
    private Integer isview;

    @Column(name = "SCORE")
    private String score;

    /**
     * 简介
     */
    @Column(name = "SUMMARY")
    private String summary;

    private static final long serialVersionUID = 1L;

    /**
     * @return VEDIOID
     */
    public Integer getVedioid() {
        return vedioid;
    }

    /**
     * @param vedioid
     */
    public void setVedioid(Integer vedioid) {
        this.vedioid = vedioid;
    }

    /**
     * @return UPDTIME
     */
    public String getUpdtime() {
        return updtime;
    }

    /**
     * @param updtime
     */
    public void setUpdtime(String updtime) {
        this.updtime = updtime;
    }

    /**
     * @return PICTURE
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return SUBNAME
     */
    public String getSubname() {
        return subname;
    }

    /**
     * @param subname
     */
    public void setSubname(String subname) {
        this.subname = subname;
    }

    /**
     * 获取1-电视剧2-电影3-动漫4-综艺1-电视剧2-电影3-动漫4-综艺5-其他
     *
     * @return CATAGORY - 1-电视剧2-电影3-动漫4-综艺1-电视剧2-电影3-动漫4-综艺5-其他
     */
    public String getCatagory() {
        return catagory;
    }

    /**
     * 设置1-电视剧2-电影3-动漫4-综艺1-电视剧2-电影3-动漫4-综艺5-其他
     *
     * @param catagory 1-电视剧2-电影3-动漫4-综艺1-电视剧2-电影3-动漫4-综艺5-其他
     */
    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    /**
     * 获取1-中国2-美国-3韩国-4英国-5-日本6-其他
     *
     * @return REGION - 1-中国2-美国-3韩国-4英国-5-日本6-其他
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置1-中国2-美国-3韩国-4英国-5-日本6-其他
     *
     * @param region 1-中国2-美国-3韩国-4英国-5-日本6-其他
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return TYPE
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return EPISODE
     */
    public Integer getEpisode() {
        return episode;
    }

    /**
     * @param episode
     */
    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    /**
     * @return NOWEPISODE
     */
    public Integer getNowepisode() {
        return nowepisode;
    }

    /**
     * @param nowepisode
     */
    public void setNowepisode(Integer nowepisode) {
        this.nowepisode = nowepisode;
    }

    /**
     * 获取0连载-1完结-2未开播
     *
     * @return ISOVER - 0连载-1完结-2未开播
     */
    public Integer getIsover() {
        return isover;
    }

    /**
     * 设置0连载-1完结-2未开播
     *
     * @param isover 0连载-1完结-2未开播
     */
    public void setIsover(Integer isover) {
        this.isover = isover;
    }

    /**
     * @return TIME
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return LATESTUPD
     */
    public String getLatestupd() {
        return latestupd;
    }

    /**
     * @param latestupd
     */
    public void setLatestupd(String latestupd) {
        this.latestupd = latestupd;
    }

    /**
     * 获取0新剧-1非新剧
     *
     * @return ISNEW - 0新剧-1非新剧
     */
    public Integer getIsnew() {
        return isnew;
    }

    /**
     * 设置0新剧-1非新剧
     *
     * @param isnew 0新剧-1非新剧
     */
    public void setIsnew(Integer isnew) {
        this.isnew = isnew;
    }

    /**
     * @return SUBCRIBECOUNT
     */
    public Integer getSubcribecount() {
        return subcribecount;
    }

    /**
     * @param subcribecount
     */
    public void setSubcribecount(Integer subcribecount) {
        this.subcribecount = subcribecount;
    }

    /**
     * @return VEDIONAME
     */
    public String getVedioname() {
        return vedioname;
    }

    /**
     * @param vedioname
     */
    public void setVedioname(String vedioname) {
        this.vedioname = vedioname;
    }

    /**
     * @return DIRECTOR
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * 获取主演
     *
     * @return ACTOR - 主演
     */
    public String getActor() {
        return actor;
    }

    /**
     * 设置主演
     *
     * @param actor 主演
     */
    public void setActor(String actor) {
        this.actor = actor;
    }

    /**
     * @return ISVIEW
     */
    public Integer getIsview() {
        return isview;
    }

    /**
     * @param isview
     */
    public void setIsview(Integer isview) {
        this.isview = isview;
    }

    /**
     * @return SCORE
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * 获取简介
     *
     * @return SUMMARY - 简介
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置简介
     *
     * @param summary 简介
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vedioid=").append(vedioid);
        sb.append(", updtime=").append(updtime);
        sb.append(", picture=").append(picture);
        sb.append(", subname=").append(subname);
        sb.append(", catagory=").append(catagory);
        sb.append(", region=").append(region);
        sb.append(", type=").append(type);
        sb.append(", episode=").append(episode);
        sb.append(", nowepisode=").append(nowepisode);
        sb.append(", isover=").append(isover);
        sb.append(", time=").append(time);
        sb.append(", latestupd=").append(latestupd);
        sb.append(", isnew=").append(isnew);
        sb.append(", subcribecount=").append(subcribecount);
        sb.append(", vedioname=").append(vedioname);
        sb.append(", director=").append(director);
        sb.append(", actor=").append(actor);
        sb.append(", isview=").append(isview);
        sb.append(", score=").append(score);
        sb.append(", summary=").append(summary);
        sb.append("]");
        return sb.toString();
    }
}