package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import streetFighter.inputs.Inputs;

public class Game {

    public static final int PADDING = 10;
    public static final int HEIGHT = 720;
    public static final int WIDTH = 1280;
    public static final int BORDER = 10;

    private MainMenu mainMenu;
    private ChooseFighter chooseFighter;

    public Game(){



    }

    public void init() {

       // mainmenu(){
        //help();
        //criar 2 players

        Rectangle screen = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        screen.draw();

        new Inputs(); //inicialização keyboard;

        MainMenu mainMenu = new MainMenu();


    }

    public void start(){

        chooseFighter = new ChooseFighter();

    }


}
