package org.academiadecodigo.roundabout.factory;

import org.academiadecodigo.roundabout.model.Challenge;
import org.academiadecodigo.roundabout.model.ChallengeType;
import org.academiadecodigo.roundabout.model.Roundabout;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChallengeFactory {

    private Integer challengesCreated = 0;
    private List<Challenge> easyChallengeList = new ArrayList<>();
    private List<Challenge> mediumChallengeList = new ArrayList<>();
    private List<Challenge> hardChallengeList = new ArrayList<>();

    public ChallengeFactory() {
        populateFactory();
    }


    public Challenge generateChallenge(int challType) {

        challengesCreated++;
        Challenge challenge = null;

        switch (challType) {

            case 1:
                challenge = chooseEasy();
                break;
            case 2:
                challenge = chooseMedium();
                break;
            case 3:
                challenge = chooseHard();
                break;

        }

        return challenge;
    }

    private Challenge chooseHard() {

        int rng = (int) ((Math.random() * 2));

        Challenge challenge = null;

        switch (rng) {
            case 0:
                challenge = hardChallengeList.get(0);
                break;
            case 1:
                challenge = hardChallengeList.get(1);
                break;
            case 2:
                challenge = hardChallengeList.get(2);
                break;
        }
        return challenge;
    }

    private Challenge chooseMedium() {

        int rng = (int) ((Math.random() * 2));

        Challenge challenge = null;

        switch (rng) {
            case 0:
                challenge = mediumChallengeList.get(0);
                break;
            case 1:
                challenge = mediumChallengeList.get(1);
                break;
            case 2:
                challenge = mediumChallengeList.get(2);
                break;
        }
        return challenge;
    }

    private Challenge chooseEasy() {

        int rng = (int) ((Math.random() * 2));

        Challenge challenge = null;

        switch (rng) {
            case 0:
                challenge = easyChallengeList.get(0);
            break;
            case 1:
                challenge = easyChallengeList.get(1);
            break;
            case 2:
                challenge = easyChallengeList.get(2);
            break;
        }
        return challenge;
    }

    public void populateFactory() {

        Challenge easyChallenge1 = new Challenge();
        Challenge easyChallenge2 = new Challenge();
        Challenge easyChallenge3 = new Challenge();

        Challenge mediumChallenge1 = new Challenge();
        Challenge mediumChallenge2 = new Challenge();
        Challenge mediumChallenge3 = new Challenge();

        Challenge hardChallenge1 = new Challenge();
        Challenge hardChallenge2 = new Challenge();
        Challenge hardChallenge3 = new Challenge();

        easyChallenge1.setChallengeName("Vai e brilha!");
        easyChallenge1.setChallengeType(ChallengeType.EASY);
        easyChallenge1.setChallengeDescription("Vai da Rotunda A à rotunda B em 15 minutos!");
        easyChallenge1.getRoundaboutList().add(new Roundabout());
        easyChallenge1.getRoundaboutList().add(new Roundabout());
        easyChallenge1.setTimeLimit(15);

        easyChallenge2.setChallengeName("Wow, árvores!");
        easyChallenge2.setChallengeType(ChallengeType.EASY);
        easyChallenge2.setChallengeDescription("Visita uma rotunda com árvores!");
        easyChallenge2.getRoundaboutList().add(new Roundabout());
        easyChallenge2.getRoundaboutList().add(new Roundabout());
        easyChallenge2.setTimeLimit(10);

        easyChallenge3.setChallengeName("What goes around comes aroundabout!");
        easyChallenge3.setChallengeType(ChallengeType.EASY);
        easyChallenge3.setChallengeDescription("Dá 5 voltas à rotunda A!");
        easyChallenge3.getRoundaboutList().add(new Roundabout());
        easyChallenge3.getRoundaboutList().add(new Roundabout());
        easyChallenge3.setTimeLimit(20);

        easyChallengeList.add(easyChallenge1);
        easyChallengeList.add(easyChallenge2);
        easyChallengeList.add(easyChallenge3);

        mediumChallenge1.setChallengeName("Vruuuum!");
        mediumChallenge1.setChallengeType(ChallengeType.MEDIUM);
        mediumChallenge1.setChallengeDescription("Vai da Rotunda A até à C, passando pela B em 50 minutos");
        mediumChallenge1.getRoundaboutList().add(new Roundabout());
        mediumChallenge1.getRoundaboutList().add(new Roundabout());
        mediumChallenge1.setTimeLimit(50);

        mediumChallenge2.setChallengeName("Tens que chegar pinheiro!");
        mediumChallenge2.setChallengeType(ChallengeType.MEDIUM);
        mediumChallenge2.setChallengeDescription("Encontra uma rotunda com pinheiros numa hora!");
        mediumChallenge2.getRoundaboutList().add(new Roundabout());
        mediumChallenge2.getRoundaboutList().add(new Roundabout());
        mediumChallenge2.setTimeLimit(60);

        mediumChallenge3.setChallengeName("Got 99 problems, but rotundas ain't one!");
        mediumChallenge3.setChallengeType(ChallengeType.MEDIUM);
        mediumChallenge3.setChallengeDescription("Atinge o máximo de rotundas visitadas durante uma hora!");
        mediumChallenge3.getRoundaboutList().add(new Roundabout());
        mediumChallenge3.getRoundaboutList().add(new Roundabout());
        mediumChallenge3.setTimeLimit(60);

        mediumChallengeList.add(mediumChallenge1);
        mediumChallengeList.add(mediumChallenge2);
        mediumChallengeList.add(mediumChallenge3);

        hardChallenge1.setChallengeName("Chirp chirp skrrtt!");
        hardChallenge1.setChallengeType(ChallengeType.MEDIUM);
        hardChallenge1.setChallengeDescription("Tira foto a um pássaro numa rotunda em uma hora!");
        hardChallenge1.getRoundaboutList().add(new Roundabout());
        hardChallenge1.getRoundaboutList().add(new Roundabout());
        hardChallenge1.setTimeLimit(60);

        hardChallenge2.setChallengeName("Vruuuuum!");
        hardChallenge2.setChallengeType(ChallengeType.MEDIUM);
        hardChallenge2.setChallengeDescription("Visita a Rotunda A, B, C e D em quatro horas!");
        hardChallenge2.getRoundaboutList().add(new Roundabout());
        hardChallenge2.getRoundaboutList().add(new Roundabout());
        hardChallenge2.setTimeLimit(240);

        hardChallenge3.setChallengeName("Special One!");
        hardChallenge3.setChallengeType(ChallengeType.MEDIUM);
        hardChallenge3.setChallengeDescription("Visita uma Rotunda que 80% dos jogadores ainda não tenham visitado em 3h horas!");
        hardChallenge3.getRoundaboutList().add(new Roundabout());
        hardChallenge3.getRoundaboutList().add(new Roundabout());
        hardChallenge3.setTimeLimit(180);

        hardChallengeList.add(hardChallenge1);
        hardChallengeList.add(hardChallenge2);
        hardChallengeList.add(hardChallenge3);

    }

}