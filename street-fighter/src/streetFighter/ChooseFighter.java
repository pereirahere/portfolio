package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import streetFighter.arena.Arena;
import streetFighter.fighters.Fighter;
import streetFighter.fighters.Fighters;
import streetFighter.fighters.PlayerType;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;


public class ChooseFighter implements ToDo {


    private Picture saraPic;
    private Picture pauloPic;
    private Picture pedroPic;
    private Picture fighter1Pic;
    private Picture saraBigPicRight;
    private Picture pauloBigPicRight;
    private Picture pedroBigPicRight;
    private Picture fighter1BigPicRight;
    private Picture saraBigPicLeft;
    private Picture pauloBigPicLeft;
    private Picture pedroBigPicLeft;
    private Picture fighter1BigPicLeft;
    private Picture versus;


    private Picture mainMenu;

    Rectangle rect1;
    Rectangle rect2;
    Rectangle rect3;
    Rectangle rect4;

    private int maxchampions = 4;

    private int pressedCharacterP1 = 1;
    private int pressedCharacterP2 = maxchampions;

    private boolean p1Ready = false;
    private boolean p2Ready = false;
    private Fighter fighterP1ready;
    private Fighter fighterP2ready;

    private int championColumns;
    private int championRow;
    private final int distanceToNextChamp = 20;
    private final int RECT_X_START = 5;
    private final int RECT_Y_START = RECT_X_START*2;

    private Rectangle[] photoFrame = new Rectangle[maxchampions];
    private Picture[] championFrame = new Picture[maxchampions];
    private Picture[] bigChampSelectFrameRight = new Picture[maxchampions];
    private Picture[] bigChampSelectFrameLeft = new Picture[maxchampions];

    private Sound optionSound = new Sound("/Resources/Sounding/SelectOptions/select2.wav");
    private Sound enterClick = new Sound("/Resources/Sounding/SelectOptions/select3.wav");
    private Sound saraSound = new Sound("/Resources/Sounding/ChoosingFighters/Sara.wav");
    private Sound pauloSound = new Sound("/Resources/Sounding/ChoosingFighters/Paulo.wav");
    private Sound pedroSound = new Sound("/Resources/Sounding/ChoosingFighters/Pedrito.wav");
    private Sound igrejaSound = new Sound("/Resources/Sounding/ChoosingFighters/Igreja.wav");

    public ChooseFighter() {
        Inputs.setInputScreen(this);

        createFighters();
    }

    public Rectangle[] getPhotoFrame() {
        return photoFrame;
    }

    public Picture[] getChampionFrame() {
        return championFrame;
    }

    public Picture[] getBigChampSelectFrameRight() {
        return bigChampSelectFrameRight;
    }

    public Picture[] getBigChampSelectFrameLeft() {
        return bigChampSelectFrameLeft;
    }

    public void createFighters() {

        mainMenu = new Picture(Game.PADDING, Game.PADDING, "elephantes_1280x720.jpeg");
        mainMenu.draw();

        championColumns = (mainMenu.getWidth() / (maxchampions + 2)) + 25;
        championRow = (int) (mainMenu.getHeight() * 0.8);


        saraPic = new Picture(championColumns * 2, championRow, "SaraIcon.png");
        championFrame[0] = saraPic;

        pauloPic = new Picture(saraPic.getX() + saraPic.getWidth() + distanceToNextChamp, championRow, "PauloIcon.png");
        pauloPic.draw();
        championFrame[1] = pauloPic;

        pedroPic = new Picture(pauloPic.getX() + pauloPic.getWidth() + distanceToNextChamp, championRow, "PedroIcon.jpeg");
        pedroPic.draw();
        championFrame[2] = pedroPic;

        fighter1Pic = new Picture(pedroPic.getX() + pedroPic.getWidth() + distanceToNextChamp, championRow, "IgrejaIcon.jpeg");

        championFrame[3] = fighter1Pic;

        rect1 = new Rectangle(saraPic.getX() - RECT_X_START, saraPic.getY() - RECT_X_START, saraPic.getWidth() + RECT_Y_START, pauloPic.getHeight() + RECT_Y_START);
        rect1.setColor(Color.RED);
        rect1.fill();
        photoFrame[0] = rect1;

        rect2 = new Rectangle(pauloPic.getX() - RECT_X_START, pauloPic.getY() - RECT_X_START, pauloPic.getWidth() + RECT_Y_START, pauloPic.getHeight() + RECT_Y_START);
        photoFrame[1] = rect2;

        rect3 = new Rectangle(pedroPic.getX() - RECT_X_START, pedroPic.getY() - RECT_X_START, pedroPic.getWidth() + RECT_Y_START, pedroPic.getHeight() + RECT_Y_START);
        photoFrame[2] = rect3;

        rect4 = new Rectangle(fighter1Pic.getX() - RECT_X_START, fighter1Pic.getY() - RECT_X_START, fighter1Pic.getWidth() + RECT_Y_START, fighter1Pic.getHeight() + RECT_Y_START);
        rect4.setColor(Color.BLUE);
        rect4.fill();
        photoFrame[3] = rect4;

        saraPic.draw();
        fighter1Pic.draw();


        // BIG PICS RIGHT
        saraBigPicRight = new Picture(200, 83, "SaraBig.png");
        bigChampSelectFrameRight[0] = saraBigPicRight;
        saraBigPicRight.draw();

        pauloBigPicRight = new Picture(200, 83, "PauloBig.png");
        bigChampSelectFrameRight[1] = pauloBigPicRight;

        pedroBigPicRight = new Picture(200, 83, "PedroBig.jpeg");
        bigChampSelectFrameRight[2] = pedroBigPicRight;

        fighter1BigPicRight = new Picture(200, 83, "IgrejaBig.jpeg");
        bigChampSelectFrameRight[3] = fighter1BigPicRight;

// BIG PICS RIGHT
        saraBigPicLeft = new Picture(670, 83, "SaraBig.png");
        bigChampSelectFrameLeft[0] = saraBigPicLeft;

        pauloBigPicLeft = new Picture(670, 83, "PauloBig.png");
        bigChampSelectFrameLeft[1] = pauloBigPicLeft;

        pedroBigPicLeft = new Picture(670, 83, "PedroBig.jpeg");
        bigChampSelectFrameLeft[2] = pedroBigPicLeft;

        fighter1BigPicLeft = new Picture(670, 83, "IgrejaBig.jpeg");
        bigChampSelectFrameLeft[3] = fighter1BigPicLeft;

        fighter1BigPicLeft.draw();

// VERSUS
       // versus = new Picture(Game.PADDING,Game.PADDING,"versus.png");
       // versus.draw();

    }

    public int getMaxChampions() {
        return maxchampions;
    }

    public void deleteAll() {
        saraPic.delete();
        pauloPic.delete();
        pedroPic.delete();
        fighter1Pic.delete();
        mainMenu.delete();

        rect1.delete();
        rect2.delete();
        rect3.delete();
        rect4.delete();

       // versus.delete();

        saraBigPicRight.delete();
        pauloBigPicRight.delete();
        pedroBigPicRight.delete();
        fighter1BigPicRight.delete();
        saraBigPicLeft.delete();
        pauloBigPicLeft.delete();
        pedroBigPicLeft.delete();
        fighter1BigPicLeft.delete();


        for (int i = 0; i < getPhotoFrame().length; i++) {
            getPhotoFrame()[i].delete();
            getChampionFrame()[i].delete();
            getBigChampSelectFrameLeft()[i].delete();
            getBigChampSelectFrameRight()[i].delete();
        }
    }


    @Override
    public void actionPressed(int key) {

        switch (key) {

            case KeyboardEvent.KEY_RIGHT:

                optionSound.play(true);

                if (p2Ready == true) {
                    break;
                }

                switch (pressedCharacterP2) {
                    case 1:
                        pressedCharacterP2++;
                        break;

                    case 2:
                        pressedCharacterP2++;
                        break;

                    case 3:
                        pressedCharacterP2++;
                        break;

                    case 4:
                        pressedCharacterP2 = 1;
                        break;
                }
                break;

            case KeyboardEvent.KEY_LEFT:

                optionSound.play(true);

                if (p2Ready == true) {
                    break;
                }

                switch (pressedCharacterP2) {

                    case 1:
                        pressedCharacterP2 = getMaxChampions();//para voltar ao ultimo
                        break;
                    case 2:
                        pressedCharacterP2--;
                        break;
                    case 3:
                        pressedCharacterP2--;
                        break;

                    case 4:
                        pressedCharacterP2--;
                        break;
                }
                break;

            case KeyboardEvent.KEY_D:

                optionSound.play(true);

                if (p1Ready == true) {
                    break;
                }

                switch (pressedCharacterP1) {
                    case 1:
                        pressedCharacterP1++;
                        break;

                    case 2:
                        pressedCharacterP1++;
                        break;

                    case 3:
                        pressedCharacterP1++;
                        break;

                    case 4:
                        pressedCharacterP1 = 1; //pq da a volta !!
                        break;
                }
                break;

            case KeyboardEvent.KEY_A:

                optionSound.play(true);

                if (p1Ready == true) {
                    break;
                }

                switch (pressedCharacterP1) {
                    case 1:
                        pressedCharacterP1 = getMaxChampions();
                        break;

                    case 2:
                        pressedCharacterP1--;
                        break;

                    case 3:
                        pressedCharacterP1--;
                        break;

                    case 4:
                        pressedCharacterP1--;
                        break;
                }
                break;

            case KeyboardEvent.KEY_1:

                enterClick.play(true);

                if (p1Ready == true) {
                    break;
                }
                p1Ready = true;

                switch (pressedCharacterP1) {
                    case 1:
                        saraSound.play(true);
                        fighterP1ready = new Fighter(PlayerType.PLAYER1, Fighters.SARA);
                        break;

                    case 2:
                        pauloSound.play(true);
                        fighterP1ready = new Fighter(PlayerType.PLAYER1, Fighters.PAULO);
                        break;

                    case 3:
                        pedroSound.play(true);
                        fighterP1ready = new Fighter(PlayerType.PLAYER1, Fighters.PEDRO);
                        break;

                    case 4:
                        igrejaSound.play(true);
                        fighterP1ready = new Fighter(PlayerType.PLAYER1, Fighters.JEANMARK);
                        break;
                }
                if (p1Ready && p2Ready) {
                    deleteAll();
                    new ChooseArena(fighterP1ready, fighterP2ready);
                }
                break;

            case KeyboardEvent.KEY_SPACE:

                enterClick.play(true);

                if (p2Ready == true) {

                    break;
                }
                p2Ready = true;

                switch (pressedCharacterP2) {
                    case 1:
                        saraSound.play(true);
                        fighterP2ready = new Fighter(PlayerType.PLAYER2, Fighters.SARA);
                        break;

                    case 2:
                        pauloSound.play(true);
                        fighterP2ready = new Fighter(PlayerType.PLAYER2, Fighters.PAULO);
                        break;

                    case 3:
                        pedroSound.play(true);
                        fighterP2ready = new Fighter(PlayerType.PLAYER2, Fighters.PEDRO);
                        break;

                    case 4:
                        igrejaSound.play(true);
                        fighterP2ready = new Fighter(PlayerType.PLAYER2, Fighters.JEANMARK);
                        break;
                }
                if (p1Ready && p2Ready) {
                    deleteAll();
                    new ChooseArena(fighterP1ready, fighterP2ready);

                }
                break;
        }
        if (!p1Ready || !p2Ready) {
            update();

        }
    }

    @Override
    public void actionReleased(int key) {

    }

    private void update() {

        for (int i = 0; i < getPhotoFrame().length; i++) {
            if (pressedCharacterP1 == i + 1 && pressedCharacterP2 == i + 1) {
                getPhotoFrame()[i].setColor(Color.WHITE);
                getPhotoFrame()[i].fill();
                getChampionFrame()[i].delete();
                getChampionFrame()[i].draw();

                getBigChampSelectFrameLeft()[i].delete();
                getBigChampSelectFrameRight()[i].delete();

                getBigChampSelectFrameRight()[i].draw();
                getBigChampSelectFrameLeft()[i].draw();
                continue;
            }

            if (pressedCharacterP1 == i + 1) {
                getPhotoFrame()[i].setColor(Color.RED);
                getPhotoFrame()[i].fill();
                getChampionFrame()[i].delete();
                getChampionFrame()[i].draw();
                getBigChampSelectFrameRight()[i].delete();
                getBigChampSelectFrameRight()[i].draw();
                continue;
            }

            if (pressedCharacterP2 == i + 1) {
                getPhotoFrame()[i].setColor(Color.BLUE);
                getPhotoFrame()[i].fill();
                getChampionFrame()[i].delete();
                getChampionFrame()[i].draw();
                getBigChampSelectFrameLeft()[i].delete();
                getBigChampSelectFrameLeft()[i].draw();
                continue;
            }
            getPhotoFrame()[i].delete();
            getBigChampSelectFrameRight()[i].delete();
            getBigChampSelectFrameLeft()[i].delete();


        }

    }

}

