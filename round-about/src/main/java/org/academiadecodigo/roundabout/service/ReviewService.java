package org.academiadecodigo.roundabout.service;


import org.academiadecodigo.roundabout.model.Review;
import org.academiadecodigo.roundabout.model.Roundabout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    private List<Review> reviewList = new ArrayList<>();
    private UserService userService;
    private ChallengeService challengeService;
    private RoundaboutService roundaboutService;

    public Review createReview(Review review){
        reviewList.add(review);
        return review;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public List<Review> getReviewsByRoundId(Integer id) {
        List<Review> retList = new ArrayList<>();
        for (Review review : reviewList) {
            if (review.getTarget().getId() == id) {
                retList.add(review);
            }
        }
        return retList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
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
    public void setRoundaboutService(RoundaboutService roundaboutService) {
        this.roundaboutService = roundaboutService;
    }
}
