package com.vsw.domain;

import java.io.Serializable;
import javax.persistence.*;

public class History implements Serializable {
    @Id
    @Column(name = "HISTORYID")
    private Integer historyid;

    @Column(name = "VEDIOID")
    private Integer vedioid;

    @Column(name = "VEDIONAME")
    private String vedioname;

    @Column(name = "ISVIEW")
    private Integer isview;

    @Column(name = "USERID")
    private Integer userid;

    @Column(name = "ISSUB")
    private Integer issub;

    @Column(name = "HISTORYD")
    private String historyd;

    private static final long serialVersionUID = 1L;

    /**
     * @return HISTORYID
     */
    public Integer getHistoryid() {
        return historyid;
    }

    /**
     * @param historyid
     */
    public void setHistoryid(Integer historyid) {
        this.historyid = historyid;
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
     * @return ISSUB
     */
    public Integer getIssub() {
        return issub;
    }

    /**
     * @param issub
     */
    public void setIssub(Integer issub) {
        this.issub = issub;
    }

    /**
     * @return HISTORYD
     */
    public String getHistoryd() {
        return historyd;
    }

    /**
     * @param historyd
     */
    public void setHistoryd(String historyd) {
        this.historyd = historyd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", historyid=").append(historyid);
        sb.append(", vedioid=").append(vedioid);
        sb.append(", vedioname=").append(vedioname);
        sb.append(", isview=").append(isview);
        sb.append(", userid=").append(userid);
        sb.append(", issub=").append(issub);
        sb.append(", historyd=").append(historyd);
        sb.append("]");
        return sb.toString();
    }
}