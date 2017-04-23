package com.big_brother.controllers;

import com.big_brother.dao.GenericDAO;
import com.big_brother.models.SystemUser;
import com.big_brother.models.UserSpied;
import com.big_brother.services.SpyService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            model.addAttribute("login", auth.getName());
        }
        return "landing";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/?logout";
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/login")
//    public String login(ModelMap map) {
//        SystemUser user = new SystemUser();
//        user.setLogin((String) map.get("uid"));
//        return "redirect:/profile/" + map.get("uid");
//    }

    @RequestMapping(value = "/profile")
    public String profile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return profilePage(auth.getName(), model);
    }

    @Transactional
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String profilePage(@PathVariable("id") String login, Model model) {

        SystemUser user = dao.get(SystemUser.class, login);
        Hibernate.initialize(user.getSpiedUsers());
        model.addAttribute("User", user);
        model.addAttribute("SpiedUsers", user.getSpiedUsers());

        //NOTE: created session and added current user id, needs to be moved to authentication when implemented
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpSession session = attr.getRequest().getSession();
//        session.setAttribute("id", login);
        model.addAttribute("newVkUser", new UserSpied());
        return "profile";
    }

    @Transactional
    @RequestMapping(value = "/profile/{id}/vkuser/{vkId}", method = RequestMethod.GET)
    public String spiedUserChart(@PathVariable("id") String login, @PathVariable("vkId") String vkId, Model model) {

        SystemUser user = dao.get(SystemUser.class, login);
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
    public String spy(@PathVariable("id") String login, @ModelAttribute("newVkUser") UserSpied userSpied) {
        SystemUser systemUser = new SystemUser();
        systemUser.setLogin(login);
        userSpied.setSystemUser(systemUser);
        spyServiceImpl.spy(userSpied);
        return "redirect:/profile/" + login;
    }

    @Autowired
    private ApplicationContext applicationContext;

    private HttpSession getCurrentSession(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession();
    }


}