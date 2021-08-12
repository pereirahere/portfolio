package org.academiadecodigo.roundabout.controller;

import org.academiadecodigo.roundabout.Bootstrap;
import org.academiadecodigo.roundabout.model.Roundabout;
import org.academiadecodigo.roundabout.service.RoundaboutService;
import org.academiadecodigo.roundabout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private Bootstrap bootstrap;
    private RoundaboutService roundaboutService;
    private UserService userService;
    private boolean hasBootstrapped;

    @Autowired
    public void setRoundaboutService(RoundaboutService roundaboutService) {
        this.roundaboutService = roundaboutService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", "", "index.html"})
    public String home(Model model) {

        if(!hasBootstrapped) {
            bootstrap.init();
        }

        model.addAttribute("isLoggedIn", userService.isLoggedIn());

        hasBootstrapped = true;
        return "index";
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/mapper"})
    public String mapper(Model model) {

        model.addAttribute("roundaboutList", roundaboutService.getRoundaboutList());

        return "mapper";
    }


}
