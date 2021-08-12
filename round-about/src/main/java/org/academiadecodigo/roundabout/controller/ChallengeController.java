package org.academiadecodigo.roundabout.controller;

import org.academiadecodigo.roundabout.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/challenge")
public class ChallengeController {

    private ChallengeService challengeService;

    @Autowired
    public void setChallengeService(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @RequestMapping(method = RequestMethod.GET, path="/diff")
    public String showDiff(Model model) {
        return "challenge/diff";
    }

    @RequestMapping(method = RequestMethod.GET, path="/{diff}")
    public String setDiff(@PathVariable Integer diff, Model model) {

        model.addAttribute("challenge", challengeService.createChallenge(diff));

        return "challenge/challenge"    ;
    }


}
