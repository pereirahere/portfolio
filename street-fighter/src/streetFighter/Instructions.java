package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;

public class Instructions implements ToDo {


    private Rectangle exitRect;
    private Text exitText;
    private Rectangle frame;
    private Rectangle instructionsMenuPic;
    private Picture keys;
    private Sound enterClick = new Sound("/Resources/Sounding/SelectOptions/select3.wav");


    public Instructions() {

        Inputs.setInputScreen(this);

        frame = new Rectangle(10,10,Game.WIDTH+10,Game.HEIGHT+10);
        frame.setColor(Color.BLACK);
        frame.fill();

        instructionsMenuPic = new Rectangle(10+10, 10+10, Game.WIDTH-10,Game.HEIGHT-10);
        instructionsMenuPic.setColor(Color.RED);
        instructionsMenuPic.fill();

        exitRect = new Rectangle(Game.WIDTH /2-50,Game.HEIGHT -Game.HEIGHT /5 + 100,100,50);
        exitRect.setColor(Color.BLACK);
        exitRect.fill();

        exitText = new Text(Game.WIDTH /2+8 - 50,Game.HEIGHT -Game.HEIGHT /5 + 18 + 100,"SPACE to exit");
        exitText.setColor(Color.WHITE);

        exitText.draw();

        keys = new Picture(10,10,"INSTRUCTIONS.png");
        keys.draw();




    }


    public void deleteInstruction() {
        instructionsMenuPic.delete();
        exitRect.delete();
        exitText.delete();
        frame.delete();
        keys.delete();
    }

    @Override
    public void actionPressed(int key) {
        switch (key){
            case KeyboardEvent.KEY_SPACE:
                enterClick.play(true);
                System.out.println("entrou");

                deleteInstruction();
                new MainMenu();
                break;
        }
    }

    @Override
    public void actionReleased(int key) {

    }
}
