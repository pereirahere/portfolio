package org.academiadecodigo.roundabout.model;

import java.util.ArrayList;
import java.util.List;

public class Challenge {

    private Integer id;
    private String challengeName;
    private List<Roundabout> roundaboutList = new ArrayList<>();
    private Integer timeLimit;
    private String challengeDescription;
    private ChallengeType challengeType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public ChallengeType getChallengeType() {
        return challengeType;
    }

    public void setChallengeType(ChallengeType challengeType) {
        this.challengeType = challengeType;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public List<Roundabout> getRoundaboutList() {
        return roundaboutList;
    }

    public void setRoundaboutList(List<Roundabout> roundaboutList) {
        this.roundaboutList = roundaboutList;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getChallengeDescription() {
        return challengeDescription;
    }

    public void setChallengeDescription(String challengeDescription) {
        this.challengeDescription = challengeDescription;
    }

}

