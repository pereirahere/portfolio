package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.arena.Arena;
import streetFighter.fighters.Fighter;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;


public class ChooseArena implements ToDo {


    private Picture arena1;
    private Picture arena2;
    private Picture arena3;
    private Picture arena4;
    private Picture chooseTitle;

    private Picture arenaBackground;

    Rectangle rect1;
    Rectangle rect2;
    Rectangle rect3;
    Rectangle rect4;

    private int arenaColumns;
    private int arenaRows;
    private final int distanceToNextArena = 20;

    private String[] arenaNames={"Resources/arena1.png",  "Resources/arena2.png", "Resources/arena3.png", "Resources/elephantes_1280x720.jpeg"};

    private int maxArena = 4;

    private int pressedArena = 1;

    private Arena arena;

    private Fighter player1;
    private Fighter player2;

    private Rectangle[] photoFrame = new Rectangle[maxArena];

    private Sound optionSound = new Sound("/Resources/Sounding/SelectOptions/select2.wav");
    private Sound enterClick = new Sound("/Resources/Sounding/SelectOptions/select3.wav");


    public ChooseArena(Fighter player1, Fighter player2) {

        Inputs.setInputScreen(this);
        this.player1 = player1;
        this.player2 = player2;


        arenaColumns = (Game.WIDTH / (maxArena + 3));
        arenaRows = (int) (Game.HEIGHT * 0.8);

        arenaBackground = new Picture(Game.PADDING, Game.PADDING, "Resources/arena1.png");
        arenaBackground.draw();

        chooseTitle = new Picture(Game.PADDING + 150,Game.PADDING,"ChooseArena.png");
        chooseTitle.draw();


        createArena();


    }


    public Rectangle[] getPhotoFrame() {
        return photoFrame;
    }

    public void createArena() {


        arena1 = new Picture((arenaColumns * 2 ) + Game.PADDING, arenaRows, "Resources/arena1Resized.png");
        arena1.draw();

        arena2 = new Picture(arena1.getX() + arena1.getWidth()  + distanceToNextArena, arenaRows, "Resources/arena2Resized.png");
        arena2.draw();

        arena3 = new Picture(arena2.getX() + arena2.getWidth() + distanceToNextArena, arenaRows, "Resources/arena3Resized.png");
        arena3.draw();

        arena4 = new Picture(arena3.getX() + arena3.getWidth() + distanceToNextArena, arenaRows, "Resources/elephantes_1280x720Resized.jpeg");
        arena4.draw();

        rect1 = new Rectangle(arena1.getX(), arena1.getY(), arena1.getWidth(), arena1.getHeight());
        rect1.setColor(Color.WHITE);
        if(pressedArena==1){
            rect1.draw();
        }


        photoFrame[0] = rect1;

        rect2 = new Rectangle(arena2.getX(), arena2.getY(), arena2.getWidth(), arena2.getHeight());
        photoFrame[1] = rect2;

        rect3 = new Rectangle(arena3.getX(), arena3.getY(), arena3.getWidth(), arena3.getHeight());
        photoFrame[2] = rect3;

        rect4 = new Rectangle(arena4.getX(), arena4.getY(), arena4.getWidth(), arena4.getHeight());
        photoFrame[3] = rect4;


    }

    public int getMaxChampions() {
        return maxArena;
    }

    public void deleteAll() {

        chooseTitle.delete();
        arena1.delete();
        arena2.delete();
        arena3.delete();
        arena4.delete();
        arenaBackground.delete();

        rect1.delete();
        rect2.delete();
        rect3.delete();
        rect4.delete();
        for (int i = 0; i < getPhotoFrame().length; i++) {
            getPhotoFrame()[i].delete();

        }
    }


    @Override
    public void actionPressed(int key) {

        switch (key) {
            case KeyboardEvent.KEY_RIGHT:

                optionSound.play(true);

                switch (pressedArena) {
                    case 4:
                        //getPhotoFrame()[pressedArena].delete();
                        pressedArena = 1;
                        //getPhotoFrame()[pressedArena].draw();
                        update();
                        break;
                    default:
                        //getPhotoFrame()[pressedArena].delete();
                        pressedArena++;
                        // getPhotoFrame()[pressedArena].draw();
                        update();
                        break;
                }
                break;

            case KeyboardEvent.KEY_LEFT:

                optionSound.play(true);

                switch (pressedArena) {
                    case 1:
                        //getPhotoFrame()[pressedArena].delete();
                        pressedArena = getMaxChampions();//para voltar ao ultimo
                        //getPhotoFrame()[pressedArena].draw();
                        update();
                        break;
                    default:
                        //getPhotoFrame()[pressedArena].delete();
                        pressedArena--;
                        //getPhotoFrame()[pressedArena].draw();
                        update();
                        break;
                }
                break;

            case KeyboardEvent.KEY_SPACE:

                enterClick.play(true);

                switch (pressedArena) {
                    case 1:
                        deleteAll();
                        chooseTitle.delete();
                        new Arena(player1, player2, "Resources/arena1.png");
                        break;

                    case 2:
                        deleteAll();
                        chooseTitle.delete();
                        new Arena(player1, player2, "Resources/arena2.png");
                        break;

                    case 3:
                        deleteAll();
                        chooseTitle.delete();
                        new Arena(player1, player2, "Resources/arena3.png");
                        break;

                    case 4:
                        deleteAll();
                        chooseTitle.delete();
                        new Arena(player1, player2, "Resources/elephantes_1280x720.jpeg");
                        break;
                }

        }




    }

    @Override
    public void actionReleased(int key) {
    }

    private void update() {

        for (int i = 0; i < getPhotoFrame().length; i++) {

          //  System.out.println(getPhotoFrame()[i]);

            if (pressedArena == i +1) {
                deleteAll();

                arenaBackground.delete();
                arenaBackground = new Picture(Game.PADDING, Game.PADDING, arenaNames[i]);
                arenaBackground.draw();
                createArena();
                getPhotoFrame()[i].setColor(Color.WHITE);
                getPhotoFrame()[i].draw();


                continue;
            }
            getPhotoFrame()[i].delete();
        }
        chooseTitle.delete();
        chooseTitle.draw();
    }
}

