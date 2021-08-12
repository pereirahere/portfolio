package org.academiadecodigo.roundabout.model;


import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String email;
    private List<Challenge> completedChallenges;
    private Challenge openChallenge;
    private List<Roundabout> visitedRoundabouts;
    private List<Review> authoredReviews;
    private Float[] coordinates;
    private String password;
    private String avatarUrl;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public User() {
        completedChallenges = new ArrayList<>();
        visitedRoundabouts = new ArrayList<>();
        authoredReviews = new ArrayList<>();
        coordinates = new Float[2];
    }

    public void addCompChal(Challenge challenge) {
        completedChallenges.add(challenge);
    }

    public void addAuthRev(Review review) {
        authoredReviews.add(review);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Challenge> getCompletedChallenges() {
        return completedChallenges;
    }

    public void setCompletedChallenges(List<Challenge> completedChallenges) {
        this.completedChallenges = completedChallenges;
    }

    public Challenge getOpenChallenge() {
        return openChallenge;
    }

    public void setOpenChallenge(Challenge openChallenge) {
        this.openChallenge = openChallenge;
    }

    public List<Roundabout> getVisitedRoundabouts() {
        return visitedRoundabouts;
    }

    public void setVisitedRoundabouts(List<Roundabout> visitedRoundabouts) {
        this.visitedRoundabouts = visitedRoundabouts;
    }

    public List<Review> getAuthoredReviews() {
        return authoredReviews;
    }

    public void setAuthoredReviews(List<Review> authoredReviews) {
        this.authoredReviews = authoredReviews;
    }
}
