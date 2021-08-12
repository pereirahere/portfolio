package org.academiadecodigo.roundabout.service;


import org.academiadecodigo.roundabout.factory.ChallengeFactory;
import org.academiadecodigo.roundabout.model.Challenge;
import org.academiadecodigo.roundabout.model.ChallengeType;
import org.academiadecodigo.roundabout.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChallengeService {

    private List<Challenge> challengeList;
    private Map<Challenge, User> onGoingChallengeList;

    private ChallengeFactory challengeFactory;
    private RoundaboutService roundaboutService;
    private UserService userService;
    private ReviewService reviewService;

    @Autowired
    public void setRoundaboutService(RoundaboutService roundaboutService) {
        this.roundaboutService = roundaboutService;
    }

    @Autowired
    public void setChallengeFactory(ChallengeFactory challengeFactory) {
        this.challengeFactory = challengeFactory;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public Challenge createChallenge(int challType) {
        return challengeFactory.generateChallenge(challType);
    }

}
