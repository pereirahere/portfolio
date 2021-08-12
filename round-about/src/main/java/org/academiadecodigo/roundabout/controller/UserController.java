package org.academiadecodigo.roundabout.controller;

import org.academiadecodigo.roundabout.model.Challenge;
import org.academiadecodigo.roundabout.model.Review;
import org.academiadecodigo.roundabout.model.Roundabout;
import org.academiadecodigo.roundabout.model.User;
import org.academiadecodigo.roundabout.service.RoundaboutService;
import org.academiadecodigo.roundabout.service.UserService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private RoundaboutService roundaboutService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoundaboutService(RoundaboutService roundaboutService) {
        this.roundaboutService = roundaboutService;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/add"})
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            redirectAttributes.addFlashAttribute("lastAction", "Failed to add user");
            return "redirect:/";
        }

        userService.createUser(user);

        redirectAttributes.addFlashAttribute("lastAction", "Added " + user.getUsername() + " !");
        return "redirect:/";

    }

    @RequestMapping(method = RequestMethod.GET, path = {"/add"})
    public String showAdd(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list"})
    public String list(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "user/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String showUser(Model model) {

        if(!userService.isLoggedIn()){
            return "redirect:/";
        }

        model.addAttribute("user", userService.getLoggedInUser());
        model.addAttribute("authoredReviews", userService.getLoggedInUser().getAuthoredReviews());
        model.addAttribute("visitedRoundabouts", userService.getLoggedInUser().getVisitedRoundabouts());
        return "user/user";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/visit/{id}"})
    public String addRound(@PathVariable Integer id) {
        userService.getLoggedInUser().getVisitedRoundabouts().add(roundaboutService.getRoundaboutById(id));
        return "redirect:/user/";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/login"})
    public String loginUser(Model model) {

        if(userService.isLoggedIn()){
            return "redirect:/user/";
        }

        model.addAttribute("user", new User());
        return "user/login";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/logout"})
    public String logout(RedirectAttributes redirectAttributes) {

        userService.logOut();
        redirectAttributes.addFlashAttribute("lastAction", "Logged out successfully!");
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/login"})
    public String loginDo(@ModelAttribute User user, RedirectAttributes redirectAttributes) {

        if (userService.logIn(user)) {
            redirectAttributes.addFlashAttribute("lastAction", "Logged in successfully!");
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("failure", "Logged in failed, Wrong Username or Password.");
        return "redirect:/";
    }

}
