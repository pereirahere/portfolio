package org.academiadecodigo.roundabout.model;

public enum ChallengeType {

    EASY(1),
    MEDIUM(2),
    HARD(3);

    private Integer diffLevel;

    ChallengeType(Integer diffLevel) {
        this.diffLevel = diffLevel;
    }
}
