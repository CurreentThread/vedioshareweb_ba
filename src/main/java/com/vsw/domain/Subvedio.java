package com.vsw.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Subvedio implements Serializable {
    @Id
    @Column(name = "SUBVEDIOID")
    private Integer subvedioid;

    @Column(name = "VEDIOID")
    private Integer vedioid;

    @Column(name = "VEDIOLINK")
    private String vediolink;

    @Column(name = "EPISODENUM")
    private Integer episodenum;

    @Column(name = "SUBVEDIONAME")
    private String subvedioname;

    @Column(name = "UPDTIME")
    private Date updtime;

    @Column(name = "FROMWHERE")
    private String fromwhere;

    @Column(name = "ISWATCHED")
    private Integer iswatched;

    @Column(name = "WATCHTIME")
    private String watchtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return SUBVEDIOID
     */
    public Integer getSubvedioid() {
        return subvedioid;
    }

    /**
     * @param subvedioid
     */
    public void setSubvedioid(Integer subvedioid) {
        this.subvedioid = subvedioid;
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
     * @return VEDIOLINK
     */
    public String getVediolink() {
        return vediolink;
    }

    /**
     * @param vediolink
     */
    public void setVediolink(String vediolink) {
        this.vediolink = vediolink;
    }

    /**
     * @return EPISODENUM
     */
    public Integer getEpisodenum() {
        return episodenum;
    }

    /**
     * @param episodenum
     */
    public void setEpisodenum(Integer episodenum) {
        this.episodenum = episodenum;
    }

    /**
     * @return SUBVEDIONAME
     */
    public String getSubvedioname() {
        return subvedioname;
    }

    /**
     * @param subvedioname
     */
    public void setSubvedioname(String subvedioname) {
        this.subvedioname = subvedioname;
    }

    /**
     * @return UPDTIME
     */
    public Date getUpdtime() {
        return updtime;
    }

    /**
     * @param updtime
     */
    public void setUpdtime(Date updtime) {
        this.updtime = updtime;
    }

    /**
     * @return FROMWHERE
     */
    public String getFromwhere() {
        return fromwhere;
    }

    /**
     * @param fromwhere
     */
    public void setFromwhere(String fromwhere) {
        this.fromwhere = fromwhere;
    }

    /**
     * @return ISWATCHED
     */
    public Integer getIswatched() {
        return iswatched;
    }

    /**
     * @param iswatched
     */
    public void setIswatched(Integer iswatched) {
        this.iswatched = iswatched;
    }

    /**
     * @return WATCHTIME
     */
    public String getWatchtime() {
        return watchtime;
    }

    /**
     * @param watchtime
     */
    public void setWatchtime(String watchtime) {
        this.watchtime = watchtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subvedioid=").append(subvedioid);
        sb.append(", vedioid=").append(vedioid);
        sb.append(", vediolink=").append(vediolink);
        sb.append(", episodenum=").append(episodenum);
        sb.append(", subvedioname=").append(subvedioname);
        sb.append(", updtime=").append(updtime);
        sb.append(", fromwhere=").append(fromwhere);
        sb.append(", iswatched=").append(iswatched);
        sb.append(", watchtime=").append(watchtime);
        sb.append("]");
        return sb.toString();
    }
}