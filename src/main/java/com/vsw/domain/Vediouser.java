package com.vsw.domain;


import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Vediouser implements Serializable {
    @Id
    @Column(name = "USERID")
    private Integer userid;

    @NotEmpty
    @Size(max = 20)
    @Column(name = "USERNAME")
    private String username;

//    @NotEmpty
    @Column(name = "USERPHOTO")
    private String userphoto;

    @NotEmpty
    @Size(max = 20,min = 7)
    @Column(name = "MOBILE")
    private String mobile;

    @NotEmpty
    @Size(max = 45)
    @Column(name = "PASSWORD")
    private String password;

    private static final long serialVersionUID = 1L;

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
     * @return USERPHOTO
     */
    public String getUserphoto() {
        return userphoto;
    }

    /**
     * @param userphoto
     */
    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    /**
     * @return MOBILE
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", userphoto=").append(userphoto);
        sb.append(", mobile=").append(mobile);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }
}