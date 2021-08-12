package org.academiadecodigo.roundabout.controller;

import org.academiadecodigo.roundabout.model.Roundabout;
import org.academiadecodigo.roundabout.model.User;
import org.academiadecodigo.roundabout.service.ReviewService;
import org.academiadecodigo.roundabout.service.RoundaboutService;
import org.academiadecodigo.roundabout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/roundabout")
public class RoundaboutController {

    private RoundaboutService roundaboutService;
    private ReviewService reviewService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoundaboutService(RoundaboutService roundaboutService) {
        this.roundaboutService = roundaboutService;
    }

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/add"})
    public String addUser(@Valid @ModelAttribute("roundabout") Roundabout roundabout, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            redirectAttributes.addFlashAttribute("lastAction", "Failed to add user");
            return "redirect:/";
        }

        roundaboutService.createRoundabout(roundabout);

        redirectAttributes.addFlashAttribute("lastAction", "Added " + roundabout.getName() + " !");
        return "redirect:/";

    }

    @RequestMapping(method = RequestMethod.GET, path = {"/add"})
    public String showAdd(Model model) {
        model.addAttribute("roundabout", new Roundabout());
        return "roundabout/add";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list"})
    public String list(Model model) {
        model.addAttribute("roundabouts", roundaboutService.getRoundaboutList());
        return "roundabout/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/map"})
    public String map(Model model) {
        List<Roundabout> roundaboutList = roundaboutService.getRoundaboutList();
        model.addAttribute(roundaboutList);
        return "map";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public String showRoundabout(@PathVariable Integer id, Model model) {

        Roundabout roundabout = roundaboutService.getRoundaboutById(id);

        if (roundabout == null) {
            return "redirect:/";
        }

        model.addAttribute("roundabout", roundabout);
        model.addAttribute("roundaboutReviews", reviewService.getReviewsByRoundId(id));
        model.addAttribute("isLoggedIn", userService.isLoggedIn());

        return "roundabout/show";
    }

}
