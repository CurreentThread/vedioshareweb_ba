package com.vsw.domain;

import java.io.Serializable;
import javax.persistence.*;

public class Subscribe implements Serializable {
    @Id
    @Column(name = "SUBID")
    private Integer subid;

    @Column(name = "USERID")
    private Integer userid;

    @Column(name = "VEDIOID")
    private Integer vedioid;

    @Column(name = "PICTURE")
    private String picture;

    @Column(name = "VEDIONAME")
    private String vedioname;

    @Column(name = "UPDTIME")
    private String updtime;

    @Column(name = "NOWEPISODE")
    private Integer nowepisode;

    /**
     * 0-NOT VIEW ,1- VIEWD
     */
    @Column(name = "ISVIEW")
    private Integer isview;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "ISSUBS")
    private Integer issubs;

    @Column(name = "ISNEW")
    private Integer isnew;

    private static final long serialVersionUID = 1L;

    /**
     * @return SUBID
     */
    public Integer getSubid() {
        return subid;
    }

    /**
     * @param subid
     */
    public void setSubid(Integer subid) {
        this.subid = subid;
    }

    /**
     * @return USERID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

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
     * 获取0-NOT VIEW ,1- VIEWD
     *
     * @return ISVIEW - 0-NOT VIEW ,1- VIEWD
     */
    public Integer getIsview() {
        return isview;
    }

    /**
     * 设置0-NOT VIEW ,1- VIEWD
     *
     * @param isview 0-NOT VIEW ,1- VIEWD
     */
    public void setIsview(Integer isview) {
        this.isview = isview;
    }

    /**
     * @return CATEGORY
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return ISSUBS
     */
    public Integer getIssubs() {
        return issubs;
    }

    /**
     * @param issubs
     */
    public void setIssubs(Integer issubs) {
        this.issubs = issubs;
    }

    /**
     * @return ISNEW
     */
    public Integer getIsnew() {
        return isnew;
    }

    /**
     * @param isnew
     */
    public void setIsnew(Integer isnew) {
        this.isnew = isnew;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subid=").append(subid);
        sb.append(", userid=").append(userid);
        sb.append(", vedioid=").append(vedioid);
        sb.append(", picture=").append(picture);
        sb.append(", vedioname=").append(vedioname);
        sb.append(", updtime=").append(updtime);
        sb.append(", nowepisode=").append(nowepisode);
        sb.append(", isview=").append(isview);
        sb.append(", category=").append(category);
        sb.append(", issubs=").append(issubs);
        sb.append(", isnew=").append(isnew);
        sb.append("]");
        return sb.toString();
    }
}