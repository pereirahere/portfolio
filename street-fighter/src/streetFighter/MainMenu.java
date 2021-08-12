package streetFighter;

import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;
import streetFighter.Sound;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainMenu implements ToDo {

    private Picture mainMenuPic;

    private Rectangle rectangleStart;
    private Rectangle rectangleInstructions;
    private Rectangle rectangleExit;

    private Text textStart;
    private Text textInstructions;
    private Text textExit;

    private Picture title;
    private Picture saraPic;
    private Picture pauloPic;
    private Picture pedroPic;
    private Picture igrejaPic;

    private int RECT_X_DEFAULT;

    private int currentlyPressedPosition = 1;

    private static boolean isSoundPlaying;
    private Sound enterClick = new Sound("/Resources/Sounding/SelectOptions/select3.wav");
    private static Sound sound = new Sound("/Resources/Sounding/MainMenu/MainMenu(loop).wav");
    private static Sound clickOptions = new Sound("/Resources/Sounding/SelectOptions/select2.wav");
    private Sound welcomeSound = new Sound("/Resources/Sounding/Welcometostreet.wav");


    //Contructor MainMenu
    public MainMenu() {

        Inputs.setInputScreen(this);

        //mainMenuPic = new Picture(10, 10, "BlackBackground2.png");
        mainMenuPic = new Picture(10, 10, "elephantes_1280x720.jpeg");
        mainMenuPic.draw();

        title = new Picture(mainMenuPic.getX() + 206, mainMenuPic.getY() + 70, "streetFighterMenuTitle.png");
        title.draw();

        RECT_X_DEFAULT = mainMenuPic.getWidth() / 2;

        saraPic = new Picture(350,350,"sara_punch_right.png");
        pedroPic = new Picture(750,350,"pedro_punch_left.png");
        pauloPic = new Picture(200,500,"paulo_punch_right.png");
        igrejaPic = new Picture(900 , 500, "igreja_punch_left.png");

        saraPic.draw();
        pedroPic.draw();
        pauloPic.grow(10,10);
        pauloPic.draw();
        igrejaPic.draw();

        currentlyPressedPosition = 1;
        drawMainMenu();

        welcomeSound.play(true);
        playSound();


    }

    // Getters Setters
    public int getCurrentlyPressedPosition() {
        return currentlyPressedPosition;
    }

    public void incrementCurrentlyPressedPosition() {
        this.currentlyPressedPosition++;
    }

    public void decrementCurrentlyPressedPosition() {
        this.currentlyPressedPosition--;
    }

    public void setCurrentlyPressedPosition(int currentlyPressedPosition) {
        this.currentlyPressedPosition = currentlyPressedPosition;
    }

    public Rectangle getRectangleStart() {
        return rectangleStart;
    }

    public Rectangle getRectangleInstructions() {
        return rectangleInstructions;
    }

    public Rectangle getRectangleExit() {
        return rectangleExit;
    }


    // methods
    public void startGame() {

        ChooseFighter chooseFighter = new ChooseFighter();
        System.out.println("start");
        deleteAll();

    }

    public void drawMainMenu() {

        //First Text
        textStart = new Text(RECT_X_DEFAULT - 25, mainMenuPic.getHeight() * (0.6) + 130, "Start street");
        textStart.setColor(Color.WHITE);
        textStart.draw();
        //First Text Rectangle
        rectangleStart = new Rectangle(textStart.getX() - 50, textStart.getY() - 10, textStart.getWidth() + 100, textStart.getHeight() + 20);
        rectangleStart.setColor(Color.WHITE);
        rectangleStart.draw();

        //Second Text
        textInstructions = new Text(textStart.getX(), textStart.getY() + 60, "Instructions");
        textInstructions.setColor(Color.WHITE);
        textInstructions.draw();
        //Second Text Rectangle
        rectangleInstructions = new Rectangle(textInstructions.getX() - 50, textInstructions.getY() - 10, textInstructions.getWidth() + 100, textInstructions.getHeight() + 20);
        rectangleInstructions.setColor(Color.WHITE);

        //Third Text
        textExit = new Text(textInstructions.getX() + 20, textInstructions.getY() + 60, "Exit");
        textExit.setColor(Color.WHITE);
        textExit.draw();
        //Third Text Rectangle
        rectangleExit = new Rectangle(textInstructions.getX() - 50, textExit.getY() - 10, textStart.getWidth() + 100, textExit.getHeight() + 20);
        rectangleExit.setColor(Color.WHITE);
    }

    public void deleteAll() {
        rectangleStart.delete();
        rectangleInstructions.delete();
        rectangleExit.delete();
        textStart.delete();
        textInstructions.delete();
        textExit.delete();
        mainMenuPic.delete();
        saraPic.delete();
        pauloPic.delete();
        pedroPic.delete();
        igrejaPic.delete();
        title.delete();
    }


    @Override
    public void actionPressed(int key) {
        switch (key) {
            case KeyboardEvent.KEY_DOWN:

                clickOptions.play(true);

                switch (getCurrentlyPressedPosition()) {

                    case 1:
                        getRectangleStart().delete();
                        getRectangleInstructions().draw();
                        incrementCurrentlyPressedPosition();
                        break;

                    case 2:
                        getRectangleInstructions().delete();
                        getRectangleExit().draw();
                        incrementCurrentlyPressedPosition();
                        break;

                    case 3:
                        getRectangleExit().delete();
                        getRectangleStart().draw();
                        setCurrentlyPressedPosition(1);
                        break;
                }
                break;

            case KeyboardEvent.KEY_UP:

                clickOptions.play(true);

                switch (getCurrentlyPressedPosition()) {

                    case 1:
                        getRectangleStart().delete();
                        getRectangleExit().draw();
                        setCurrentlyPressedPosition(3);
                        break;

                    case 2:
                        getRectangleInstructions().delete();
                        getRectangleStart().draw();
                        decrementCurrentlyPressedPosition();
                        break;

                    case 3:
                        getRectangleExit().delete();
                        getRectangleInstructions().draw();
                        decrementCurrentlyPressedPosition();
                        break;
                }
                break;

            case KeyboardEvent.KEY_SPACE:

                enterClick.play(true);

                switch (getCurrentlyPressedPosition()) {

                    case 1:
                        System.out.println("1");
                        deleteAll();
                        startGame();
                        break;

                    case 2:
                        System.out.println("2");
                        deleteAll();
                        new Instructions();
                        break;

                    case 3:
                        // Exit clause (DONE)
                        System.out.println("3");
                        Runtime.getRuntime().exit(0);
                        break;
                    default:
                        System.out.println("DEFAULT");
                }
                break;
        }
    }

    @Override
    public void actionReleased(int key) {

    }

    public static void playSound() {
        if (isSoundPlaying) {
            return;
        }
        sound.setLoop(20);
        isSoundPlaying = true;
    }

    public static void stopSound() {
        if (!isSoundPlaying) {
            return;
        }
        sound.stop();
        isSoundPlaying = false;
    }


}

