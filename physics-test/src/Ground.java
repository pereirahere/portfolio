import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.stream.Stream;

public class Ground {

    Rectangle ground;
    private double height;
    private double width;

    public Ground () {

        width = 1280;
        height = 720;
        ground = new Rectangle(0, 0, width, height);
        drawGround();

    }


    public void drawGround () {

        ground.setColor(Color.WHITE);
        ground.draw();
        ground.fill();

    }

    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }


}
