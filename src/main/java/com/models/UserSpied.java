package com.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alex on 02.04.2017.
 */
@Entity
@IdClass(UserSpiedPK.class)
public class UserSpied {
    private User user;
    private VKUser vkUser;
    private int periodicity;

    @Id
    @ManyToOne
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_USER"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(int periodicity) {
        this.periodicity = periodicity;
    }
}

class UserSpiedPK implements Serializable {
    protected VKUser vkUser;
    protected User user;

    public UserSpiedPK() {}

    public UserSpiedPK(VKUser vkUser, User user) {
        this.vkUser = vkUser;
        this.user = user;
    }
}
