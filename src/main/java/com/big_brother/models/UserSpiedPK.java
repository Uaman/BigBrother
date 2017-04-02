package com.big_brother.models;

import java.io.Serializable;

public class UserSpiedPK implements Serializable {
    protected VKUser vkUser;
    protected SystemUser systemUser;

    public UserSpiedPK() {}

    public UserSpiedPK(VKUser vkUser, SystemUser systemUser) {
        this.vkUser = vkUser;
        this.systemUser = systemUser;
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
}
