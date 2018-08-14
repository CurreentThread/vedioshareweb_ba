package com.vsw.domain;

import java.io.Serializable;
import javax.persistence.*;

public class Slot implements Serializable {
    @Id
    @Column(name = "SLOTSID")
    private Integer slotsid;

    @Column(name = "OPRATENAME")
    private String opratename;

    @Column(name = "VEDIOID")
    private Integer vedioid;

    @Column(name = "VEDIONAME")
    private String vedioname;

    @Column(name = "LISTID")
    private Integer listid;

    @Column(name = "LISTNAME")
    private String listname;

    @Column(name = "OPRATETIME")
    private String opratetime;

    @Column(name = "OPRATEDAY")
    private String oprateday;

    @Column(name = "USERID")
    private Integer userid;

    private static final long serialVersionUID = 1L;

    /**
     * @return SLOTSID
     */
    public Integer getSlotsid() {
        return slotsid;
    }

    /**
     * @param slotsid
     */
    public void setSlotsid(Integer slotsid) {
        this.slotsid = slotsid;
    }

    /**
     * @return OPRATENAME
     */
    public String getOpratename() {
        return opratename;
    }

    /**
     * @param opratename
     */
    public void setOpratename(String opratename) {
        this.opratename = opratename;
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
     * @return OPRATETIME
     */
    public String getOpratetime() {
        return opratetime;
    }

    /**
     * @param opratetime
     */
    public void setOpratetime(String opratetime) {
        this.opratetime = opratetime;
    }

    /**
     * @return OPRATEDAY
     */
    public String getOprateday() {
        return oprateday;
    }

    /**
     * @param oprateday
     */
    public void setOprateday(String oprateday) {
        this.oprateday = oprateday;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", slotsid=").append(slotsid);
        sb.append(", opratename=").append(opratename);
        sb.append(", vedioid=").append(vedioid);
        sb.append(", vedioname=").append(vedioname);
        sb.append(", listid=").append(listid);
        sb.append(", listname=").append(listname);
        sb.append(", opratetime=").append(opratetime);
        sb.append(", oprateday=").append(oprateday);
        sb.append(", userid=").append(userid);
        sb.append("]");
        return sb.toString();
    }
}