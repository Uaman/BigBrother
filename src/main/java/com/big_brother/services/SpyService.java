package com.big_brother.services;

import com.big_brother.models.UserSpied;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Service;

import java.util.Timer;

/**
 * Created by Alex on 03.04.2017.
 */

public class SpyService {
    private UserSpied userSpied;

    public SpyService(UserSpied userSpied){
        this.userSpied = userSpied;
    }

    public void spy(){
        Timer time = new Timer();
        ScheduledSpyTask spyTask = new ScheduledSpyTask(userSpied);
        time.schedule(spyTask, 0, userSpied.getPeriodicity());
    }
}
