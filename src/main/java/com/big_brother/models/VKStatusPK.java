package com.big_brother.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by denysburlakov on 02.04.17.
 */
class VKStatusPK implements Serializable {
    protected VKUser vkUser;
    protected SystemUser systemUser;
    protected Date date;

    public VKStatusPK() {}

    public VKStatusPK(VKUser vkUser, SystemUser systemUser, Date date) {
        this.vkUser = vkUser;
        this.systemUser = systemUser;
        this.date = date;
    }

    public VKUser getVkUser() {
        return vkUser;
    }

    public void setVkUser(VKUser vkUser) {
        this.vkUser = vkUser;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
