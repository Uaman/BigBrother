package com.big_brother.services;

import com.big_brother.dao.GenericDAO;
import com.big_brother.models.UserSpied;
import com.big_brother.models.VKStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Alex on 03.04.2017.
 */

public class ScheduledSpyTask extends TimerTask{

    private UserSpied userSpied;

    @Override
    public void run() {
        boolean isOnline = VKApiService.getVKUserStatus(userSpied.getVkUser().getVkId());
        VKStatus vkStatus = new VKStatus();

        vkStatus.setVkUser(userSpied.getVkUser());
        vkStatus.setSystemUser(userSpied.getSystemUser());
        vkStatus.setDate(new Date());
        vkStatus.setOnline(isOnline);
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        context.getBean(GenericDAO.class).save(vkStatus);
    }

    public UserSpied getUserSpied() {
        return userSpied;
    }

    public void setUserSpied(UserSpied userSpied) {
        this.userSpied = userSpied;
    }
}
