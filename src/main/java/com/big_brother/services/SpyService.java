package com.big_brother.services;

import com.big_brother.models.UserSpied;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Alex on 03.04.2017.
 */

@Service
public class SpyService {
    @Autowired
    ScheduledSpyTask spyTask;

    @Transactional
    public void spy(UserSpied userSpied){
        Timer time = new Timer();
        spyTask.setUserSpied(userSpied);
        time.schedule(spyTask, 0, userSpied.getPeriodicity());
    }
}
