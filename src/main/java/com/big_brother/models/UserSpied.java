package com.big_brother.models;

import javax.persistence.*;

/**
 * Created by Alex on 02.04.2017.
 */
@Entity
@IdClass(UserSpiedPK.class)
public class UserSpied {
    private SystemUser systemUser;
    private VKUser vkUser;
    private long periodicity;

    @Id
    @ManyToOne
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_USER"))
    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "VK_USER_ID", foreignKey = @ForeignKey(name = "FK_VK_USER"))
    public VKUser getVkUser() {
        return vkUser;
    }

    public void setVkUser(VKUser vkUser) {
        this.vkUser = vkUser;
    }

    public long getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(long periodicity) {
        this.periodicity = periodicity;
    }
}

