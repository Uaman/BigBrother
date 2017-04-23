package com.big_brother.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by Alex on 02.04.2017.
 */
@Entity
public class SystemUser {
    private String login;
    private String password;
    private Set<VKStatus> statuses;
    private Set<UserSpied> spiedUsers;

    @Id
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "systemUser")
    public Set<VKStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<VKStatus> statuses) {
        this.statuses = statuses;
    }

    @OneToMany(mappedBy = "systemUser")
    public Set<UserSpied> getSpiedUsers() {
        return spiedUsers;
    }

    public void setSpiedUsers(Set<UserSpied> spiedUsers) {
        this.spiedUsers = spiedUsers;
    }
}
