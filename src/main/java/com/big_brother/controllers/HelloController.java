package com.big_brother.controllers;

import com.big_brother.dao.GenericDAO;
import com.big_brother.models.SystemUser;
import com.big_brother.models.UserSpied;
import com.big_brother.models.VKUser;
import com.big_brother.services.SpyService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

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

        //NOTE: created session and added current user id, needs to be moved to authentication when implemented
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpSession session = attr.getRequest().getSession();
//        session.setAttribute("id", userId);
        model.addAttribute("newVkUser", new UserSpied());
        return "profile";
    }

    @Transactional
    @RequestMapping(value = "/profile/{id}/vkuser/{vkId}", method = RequestMethod.GET)
    public String spiedUserChart(@PathVariable("id") Integer userId, @PathVariable("vkId") String vkId, Model model) {

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

    @RequestMapping(value = "/profile/{id}/vkuser", method = RequestMethod.POST)
    public String spy(@PathVariable("id") Integer userId, @ModelAttribute("newVkUser") UserSpied userSpied) {
        SystemUser systemUser = new SystemUser();
        systemUser.setUserId(userId);
        userSpied.setSystemUser(systemUser);
        spyServiceImpl.spy(userSpied);
        return "redirect:/profile/" + userId;
    }

    @Autowired
    private ApplicationContext applicationContext;

    private HttpSession getCurrentSession(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession();
    }


}