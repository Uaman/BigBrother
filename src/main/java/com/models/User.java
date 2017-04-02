package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by Alex on 02.04.2017.
 */
@Entity
public class User {
    private int userId;
    private String login;
    private String email;
    private Set<VKStatus> statuses;
    private Set<UserSpied> spiedUsers;

    @Id
    @GeneratedValue
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user")
    public Set<VKStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<VKStatus> statuses) {
        this.statuses = statuses;
    }

    @OneToMany(mappedBy = "user")
    public Set<UserSpied> getSpiedUsers() {
        return spiedUsers;
    }

    public void setSpiedUsers(Set<UserSpied> spiedUsers) {
        this.spiedUsers = spiedUsers;
    }
}
