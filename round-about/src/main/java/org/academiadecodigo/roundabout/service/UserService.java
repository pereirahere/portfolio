package org.academiadecodigo.roundabout.service;

import org.academiadecodigo.roundabout.model.Review;
import org.academiadecodigo.roundabout.model.Roundabout;
import org.academiadecodigo.roundabout.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>();
    private RoundaboutService roundaboutService;
    private ChallengeService challengeService;
    private ReviewService reviewService;
    private User loggedInUser;



    public User createUser(User user){
        userList.add(user);
        return user;
    }

    public boolean isLoggedIn(){
        if(loggedInUser==null) {return false;}
        return true;
    }

    public boolean logIn(User user){

        for (User user2 : userList) {
            if (user2.getUsername().equals(user.getUsername()) && user2.getPassword().equals(user.getPassword())) {
                this.loggedInUser = user2;
                return true;
            }
        }
        return false;
    }

    public boolean logOut() {
        if (isLoggedIn()) {
            this.loggedInUser = null;
            return true;
        }
        return false;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    @Autowired
    public void setRoundaboutService(RoundaboutService roundaboutService) {
        this.roundaboutService = roundaboutService;
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
