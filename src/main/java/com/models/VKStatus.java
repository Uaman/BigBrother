package com.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alex on 02.04.2017.
 */
@Entity
@IdClass(VKStatusPK.class)
public class VKStatus {
    private VKUser vkUser;
    private boolean online;
    private Date date;
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "VK_USER_ID", foreignKey = @ForeignKey(name = "FK_VK_USER"))
    public VKUser getVkUser() {
        return vkUser;
    }

    public void setVkUser(VKUser vkUser) {
        this.vkUser = vkUser;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Id
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_USER"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

class VKStatusPK implements Serializable {
    protected VKUser vkUser;
    protected User user;
    protected Date date;

    public VKStatusPK() {}

    public VKStatusPK(VKUser vkUser, User user, Date date) {
        this.vkUser = vkUser;
        this.user = user;
        this.date = date;
    }
}
