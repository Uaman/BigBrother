package com.big_brother.controllers;

import com.big_brother.dao.GenericDAO;
import com.big_brother.models.SystemUser;
import com.big_brother.models.UserSpied;
import com.big_brother.models.VKUser;
import com.big_brother.services.SpyService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by zvazhiidmytro on 18.03.17.
 */
@Controller
@RequestMapping("/")
public class HelloController {
    @Autowired
    private SpyService spyServiceImpl;

    @Autowired
    private GenericDAO dao;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "landing";
    }

    @Transactional
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String profilePage(@PathVariable("id") Integer userId, Model model) {

        SystemUser user = dao.get(SystemUser.class, userId);
        Hibernate.initialize(user.getSpiedUsers());
        model.addAttribute("User", user);
        model.addAttribute("SpiedUsers", user.getSpiedUsers());

        return "profile";
    }

    @Transactional
    @RequestMapping(value = "/profile/{id}/vkuser/{vkId}", method = RequestMethod.GET)
    public String spiedUserChart(@PathVariable("id") Integer userId, @PathVariable("id") String vkId, Model model) {

        SystemUser user = dao.get(SystemUser.class, userId);
        UserSpied spiedUser = new UserSpied();
        for (UserSpied vkUser:user.getSpiedUsers()) {
            if(vkUser.getVkUser().getVkId().equals(vkId)){
                spiedUser = vkUser;
            }
        }

        Hibernate.initialize(spiedUser.getVkUser().getStatuses());
        model.addAttribute("Statuses", spiedUser.getVkUser().getStatuses());

        return "spiedUserChart";
    }

    @RequestMapping(value = "/spy", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void spy(ModelMap model) {
        UserSpied userSpied = new UserSpied();
        VKUser vkUser = new VKUser();
        vkUser.setVkId("1");
        SystemUser systemUser = new SystemUser();
        systemUser.setUserId(1);
        userSpied.setVkUser(vkUser);
        userSpied.setSystemUser(systemUser);
        userSpied.setPeriodicity(10000);
        spyServiceImpl.spy(userSpied);
    }


    @Autowired
    private ApplicationContext applicationContext;


}