import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Floor {

    Rectangle floor;

    private int x;
    private int y;
    private int width;
    private double height;


    public Floor () {

        x = 0;
        y = 600;
        width = 1280;
        height = 100;

        floor = new Rectangle(x + Mech.PADDING, y, width,height);
        drawFloor();

    }


    public void drawFloor () {
        floor.setColor(Color.GRAY);
        floor.draw();
        floor.fill();
    }

    public int getY(){
        return y;
    }

    public double getHeight() {
        return height;
    }

}
