package com.big_brother.models;

import javax.persistence.*;
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
    private SystemUser systemUser;

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
    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
}

