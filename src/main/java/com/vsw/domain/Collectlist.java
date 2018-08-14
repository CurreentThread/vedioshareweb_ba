package com.vsw.domain;

import java.io.Serializable;
import javax.persistence.*;

public class Collectlist implements Serializable {
    @Id
    @Column(name = "COLLECTID")
    private Integer collectid;

    @Column(name = "LISTID")
    private Integer listid;

    @Column(name = "USERID")
    private Integer userid;

    @Column(name = "COLLECTNUM")
    private Integer collectnum;

    private static final long serialVersionUID = 1L;

    /**
     * @return COLLECTID
     */
    public Integer getCollectid() {
        return collectid;
    }

    /**
     * @param collectid
     */
    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
    }

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
     * @return COLLECTNUM
     */
    public Integer getCollectnum() {
        return collectnum;
    }

    /**
     * @param collectnum
     */
    public void setCollectnum(Integer collectnum) {
        this.collectnum = collectnum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", collectid=").append(collectid);
        sb.append(", listid=").append(listid);
        sb.append(", userid=").append(userid);
        sb.append(", collectnum=").append(collectnum);
        sb.append("]");
        return sb.toString();
    }
}