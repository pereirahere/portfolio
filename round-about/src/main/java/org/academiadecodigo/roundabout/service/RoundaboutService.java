package org.academiadecodigo.roundabout.service;


import org.academiadecodigo.roundabout.model.Roundabout;
import org.academiadecodigo.roundabout.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoundaboutService {

    private List<Roundabout> roundaboutList = new ArrayList<>();
    private UserService userService;
    private ChallengeService challengeService;
    private ReviewService reviewService;
    private Integer roundaboutsCreated = 0;

    public Roundabout createRoundabout(Roundabout roundabout){

        roundaboutsCreated++;
        roundabout.setId(roundaboutsCreated);
        roundaboutList.add(roundabout);
        return roundabout;
    }

    public Roundabout getRoundaboutByName(String name){

        for(Roundabout rutund: roundaboutList){
            if(rutund.getName().equals(name)){
                return rutund;
            }
        }
        return null;
    }

    public Roundabout getRoundaboutById(Integer id){

        for(Roundabout rutund: roundaboutList){
            if(rutund.getId() == id){
                return rutund;
            }
        }
        return null;
    }

    public List<Roundabout> getRoundaboutList() {
        return roundaboutList;
    }

    public void setRoundaboutList(List<Roundabout> roundaboutList) {
        this.roundaboutList = roundaboutList;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setChallengeService(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


}
