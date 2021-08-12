package org.academiadecodigo.roundabout;

import org.academiadecodigo.roundabout.factory.ChallengeFactory;
import org.academiadecodigo.roundabout.model.Review;
import org.academiadecodigo.roundabout.model.Roundabout;
import org.academiadecodigo.roundabout.model.User;
import org.academiadecodigo.roundabout.service.ChallengeService;
import org.academiadecodigo.roundabout.service.ReviewService;
import org.academiadecodigo.roundabout.service.RoundaboutService;
import org.academiadecodigo.roundabout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Bootstrap {

    private RoundaboutService roundaboutService;
    private ReviewService reviewService;
    private UserService userService;
    private ChallengeService challengeService;

    @Autowired
    public void setRoundaboutService(RoundaboutService roundaboutService) {
        this.roundaboutService = roundaboutService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Autowired
    public void setChallengeService(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    public void init() {

        Roundabout roundabout1 = new Roundabout();
        Roundabout roundabout2 = new Roundabout();
        Roundabout roundabout3 = new Roundabout();
        Roundabout roundabout4 = new Roundabout();

        roundabout1.setName("Produtos Estrela - Porto");
        roundabout1.setxCoord("41.17809347485867");
        roundabout1.setyCoord("-8.655501736117198");

        roundabout2.setName("Anémona - Matosinhos");
        roundabout2.setxCoord("41.173494951131");
        roundabout2.setyCoord("-8.688721567577591");

        roundabout3.setName("Rotunda da Boavista - Porto");
        roundabout3.setxCoord("41.15780025168437");
        roundabout3.setyCoord("-8.629111909996846");

        roundabout4.setName("Marquês de Pombal - Lisboa");
        roundabout4.setxCoord("38.725251676348016");
        roundabout4.setyCoord("-9.150133424827951");

        roundaboutService.createRoundabout(roundabout1);
        roundaboutService.createRoundabout(roundabout2);
        roundaboutService.createRoundabout(roundabout3);
        roundaboutService.createRoundabout(roundabout4);

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        user1.setUsername("Stevenson");
        user1.setPassword("lidar");
        user1.setEmail("stevenson@gmail.globe");
        user1.setAvatarUrl("https://toppng.com/uploads/preview/" +
                "my-anus-after-being-pounded-by-big-brother-admins-best-profile-" +
                "picture-discord-11563024714nfasaviw6z.png");

        user2.setUsername("Hádança");
        user2.setPassword("Beyoncé");
        user2.setEmail("1@1.1");

        user3.setUsername("JohnnyBoy");
        user3.setPassword("Pumped up kicks");
        user3.setEmail("1@1.1");

        user4.setUsername("Yoloers");
        user4.setPassword("bitches");
        user4.setEmail("1@1.1");

        Review review1 = new Review();
        review1.setReviewText("pash, nunca vital. Esta rotunda dá-me a volta à cabeça. Gostei muito. Experiência inesquecivel de circularidade!");
        review1.setRating(5);
        review1.setAuthor(user1);
        review1.setTarget(roundabout1);

        List<Roundabout> roundaboutList = user1.getVisitedRoundabouts();
        roundaboutList.add(roundabout1);
        user1.setVisitedRoundabouts(roundaboutList);
        user1.getAuthoredReviews().add(review1);

        reviewService.createReview(review1);

        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);
        userService.createUser(user4);


        System.out.println("Piças");
        roundaboutList.stream().forEach(System.out::println);

    }
}
