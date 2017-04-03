package com.big_brother.services;

import com.big_brother.dao.GenericDAO;
import com.big_brother.models.SystemUser;
import com.big_brother.models.UserSpied;
import com.big_brother.models.VKStatus;
import com.big_brother.models.VKUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Alex on 03.04.2017.
 */
@Component
public class ScheduledSpyTask extends TimerTask{

    @Autowired
    private GenericDAO dao;

    private UserSpied userSpied;

    @Override
    public void run() {
        boolean isOnline = VKApiService.getVKUserStatus(userSpied.getVkUser().getVkId());
        VKStatus vkStatus = new VKStatus();

        vkStatus.setVkUser(userSpied.getVkUser());
        vkStatus.setSystemUser(userSpied.getSystemUser());
        vkStatus.setDate(new Date());
        vkStatus.setOnline(isOnline);

        dao.save(vkStatus);
    }

    public UserSpied getUserSpied() {
        return userSpied;
    }

    public void setUserSpied(UserSpied userSpied) {
        this.userSpied = userSpied;
    }
}
