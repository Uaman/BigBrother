package com.big_brother.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by Alex on 02.04.2017.
 */
@Entity
public class VKUser {
    private String vkId;
    private String firstName;
    private String lastName;
    private Set<VKStatus> statuses;
    private Set<UserSpied> spiedUsers;

    @Id
    public String getVkId() {
        return vkId;
    }

    public void setVkId(String vkId) {
        this.vkId = vkId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "vkUser")
    public Set<VKStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<VKStatus> statuses) {
        this.statuses = statuses;
    }

    @OneToMany(mappedBy = "vkUser")
    public Set<UserSpied> getSpiedUsers() {
        return spiedUsers;
    }

    public void setSpiedUsers(Set<UserSpied> spiedUsers) {
        this.spiedUsers = spiedUsers;
    }
}
