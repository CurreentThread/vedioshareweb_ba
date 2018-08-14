package com.vsw.domain;

import java.io.Serializable;
import javax.persistence.*;

public class Listvedio implements Serializable {
    @Id
    @Column(name = "LISTVEDIOID")
    private Integer listvedioid;

    @Column(name = "LISTID")
    private Integer listid;

    @Column(name = "VEDIOID")
    private Integer vedioid;

    @Column(name = "VEDIONAME")
    private String vedioname;

    @Column(name = "VEDIOPICTURE")
    private String vediopicture;

    @Column(name = "UPDTIME")
    private String updtime;

    @Column(name = "ISVIEW")
    private Integer isview;

    @Column(name = "CATEGROY")
    private String categroy;

    @Column(name = "NOWEPISODE")
    private Integer nowepisode;

    @Column(name = "ISOVER")
    private Integer isover;

    @Column(name = "ISSUB")
    private Integer issub;

    private static final long serialVersionUID = 1L;

    /**
     * @return LISTVEDIOID
     */
    public Integer getListvedioid() {
        return listvedioid;
    }

    /**
     * @param listvedioid
     */
    public void setListvedioid(Integer listvedioid) {
        this.listvedioid = listvedioid;
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
     * @return VEDIOPICTURE
     */
    public String getVediopicture() {
        return vediopicture;
    }

    /**
     * @param vediopicture
     */
    public void setVediopicture(String vediopicture) {
        this.vediopicture = vediopicture;
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
     * @return CATEGROY
     */
    public String getCategroy() {
        return categroy;
    }

    /**
     * @param categroy
     */
    public void setCategroy(String categroy) {
        this.categroy = categroy;
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
     * @return ISOVER
     */
    public Integer getIsover() {
        return isover;
    }

    /**
     * @param isover
     */
    public void setIsover(Integer isover) {
        this.isover = isover;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", listvedioid=").append(listvedioid);
        sb.append(", listid=").append(listid);
        sb.append(", vedioid=").append(vedioid);
        sb.append(", vedioname=").append(vedioname);
        sb.append(", vediopicture=").append(vediopicture);
        sb.append(", updtime=").append(updtime);
        sb.append(", isview=").append(isview);
        sb.append(", categroy=").append(categroy);
        sb.append(", nowepisode=").append(nowepisode);
        sb.append(", isover=").append(isover);
        sb.append(", issub=").append(issub);
        sb.append("]");
        return sb.toString();
    }
}