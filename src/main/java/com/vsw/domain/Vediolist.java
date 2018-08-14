package com.vsw.domain;

import java.io.Serializable;
import javax.persistence.*;

public class Vediolist implements Serializable {
    @Id
    @Column(name = "LISTID")
    private Integer listid;

    @Column(name = "LISTNAME")
    private String listname;

    @Column(name = "COUNT")
    private Integer count;

    @Column(name = "COVERIMAGE")
    private String coverimage;

    @Column(name = "USERID")
    private Integer userid;

    @Column(name = "CREATETIME")
    private String createtime;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "HOT")
    private Integer hot;

    private static final long serialVersionUID = 1L;

    /**
     * @return LISTID
     */
    public Integer getListid() {
        return listid;
    }

    /**
     * @param listid
     */
    public void setListid(Integer listid) {
        this.listid = listid;
    }

    /**
     * @return LISTNAME
     */
    public String getListname() {
        return listname;
    }

    /**
     * @param listname
     */
    public void setListname(String listname) {
        this.listname = listname;
    }

    /**
     * @return COUNT
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return COVERIMAGE
     */
    public String getCoverimage() {
        return coverimage;
    }

    /**
     * @param coverimage
     */
    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
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
     * @return CREATETIME
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * @return USERNAME
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return SUMMARY
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return HOT
     */
    public Integer getHot() {
        return hot;
    }

    /**
     * @param hot
     */
    public void setHot(Integer hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", listid=").append(listid);
        sb.append(", listname=").append(listname);
        sb.append(", count=").append(count);
        sb.append(", coverimage=").append(coverimage);
        sb.append(", userid=").append(userid);
        sb.append(", createtime=").append(createtime);
        sb.append(", username=").append(username);
        sb.append(", summary=").append(summary);
        sb.append(", hot=").append(hot);
        sb.append("]");
        return sb.toString();
    }
}