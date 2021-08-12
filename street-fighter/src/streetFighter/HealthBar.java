
package streetFighter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.fighters.Fighter;

public class HealthBar {

    private Text player1Name;
    private Text player2Name;
    private Text text;

    Rectangle rectangleP1;
    Rectangle lifeP1;

    Rectangle rectangleP2;
    Rectangle lifeP2;

    private Picture mainMenu;
    private int healthP1 = 50;
    private int healthP2 = 90;
    private int barWidth = 500;
    private int barHeight = 40;
    private int maxHealth = 100;
    private Fighter player1;
    private Fighter player2;


    private int BORDER = 5;


    public HealthBar(Fighter player1, Fighter player2) {

        this.player1 = player1;
        this.player2 = player2;

        this.healthP1 = player1.getHealth();
        this.healthP2 = player2.getHealth();
        init();

    }

    public void init() {

        rectangleP1 = new Rectangle(Game.PADDING+ 70, Game.PADDING +50, barWidth, barHeight);
        rectangleP1.setColor(Color.BLACK);
        rectangleP1.fill();

        player1Name = new Text(rectangleP1.getX() + 25, rectangleP1.getY() - 20,player1.getFighter().name());
        player1Name.setColor(Color.WHITE);
        player1Name.grow(25,10);
        player1Name.draw();

        rectangleP2 = new Rectangle(Game.WIDTH - 70 - barWidth, Game.PADDING +50, barWidth, barHeight);
        rectangleP2.setColor(Color.BLACK);
        rectangleP2.fill();

        player2Name = new Text(rectangleP2.getX()+rectangleP2.getWidth()-50 - 25, rectangleP2.getY() - 20,player2.getFighter().name());
        player2Name.setColor(Color.WHITE);
        player2Name.grow(25,10);
        player2Name.draw();



        lifeP1 = new Rectangle(rectangleP1.getX()+ BORDER, rectangleP1.getY() + BORDER, (rectangleP1.getWidth()-10) * healthP1 /100, rectangleP1.getHeight()- 10 );

        lifeP2 = new Rectangle(rectangleP2.getX() + ((100 - healthP2)*4.9) + BORDER, rectangleP2.getY() + BORDER, (rectangleP2.getWidth()-10) * healthP2 /100, rectangleP2.getHeight()- 10 );

        if(healthP1 < 33) {
            lifeP1.setColor(Color.RED);
        }
        else if (healthP1 < 60) {
            lifeP1.setColor(Color.YELLOW);
        }
        else if( healthP1 < 101) {
            lifeP1.setColor(Color.GREEN);
        }

        lifeP1.fill();

        if(healthP2 < 33) {
            lifeP2.setColor(Color.RED);
        }
        else if (healthP2 < 60) {
            lifeP2.setColor(Color.YELLOW);
        }
        else if( healthP2 < 101) {
            lifeP2.setColor(Color.GREEN);
        }

        lifeP2.fill();

    }
    public void healthBarDelete(){
        rectangleP1.delete();
        rectangleP2.delete();
        lifeP1.delete();
        lifeP2.delete();
    }
}

