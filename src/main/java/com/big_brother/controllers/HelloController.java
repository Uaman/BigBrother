package com.big_brother.controllers;

import com.big_brother.models.SystemUser;
import com.big_brother.models.UserSpied;
import com.big_brother.models.VKUser;
import com.big_brother.services.SpyService;
import com.big_brother.services.SpyTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "landing";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilePage(ModelMap model) {

        return "profile";
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