package com.big_brother.services;

import com.big_brother.dao.GenericDAO;
import com.big_brother.models.UserSpied;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Alex on 03.04.2017.
 */

@Service
public class SpyService {
    @Autowired
    GenericDAO dao;

    @PostConstruct
    @Transactional
    public void setupSpying(){
        dao.getAll(UserSpied.class).forEach(this::startSpying);
    }

    @Transactional
    public void spy(UserSpied userSpied){
        dao.saveOrUpdate(userSpied.getVkUser());
        dao.save(userSpied);
        startSpying(userSpied);
    }

    private void startSpying(UserSpied userSpied) {
        Timer time = new Timer();
        ScheduledSpyTask spyTask = new ScheduledSpyTask();
        spyTask.setUserSpied(userSpied);
        time.schedule(spyTask, 0, userSpied.getPeriodicity());
    }
}
