import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Subject implements KeyboardHandler {

    private Ellipse subject;

    private double startingX;
    private double startingY;
    private double y;
    private double x;
    private double width;
    private double height;

    private Mech mech;

    public Subject(int startingX, int startingY, int width, int height, Mech mech) {

        this.startingX = startingX;
        this.startingY = startingY;
        this.width = width;
        this.height = height;
        this.mech = mech;

        y = startingY;
        x = startingX;


        subject = new Ellipse(startingX, startingY, width, height);
        drawSubject();
        keyboardInit();

    }

    public void drawSubject() {

        subject.setColor(Color.BLACK);
        subject.draw();
        subject.fill();

    }

    public void pushY(double speed) {
        subject.translate(0, speed);
    }

    public void pushX(double speed) {
        subject.translate(speed, 0);
    }

    public double getY() {
        return subject.getY();
    }

    public double getX() {
        return subject.getX();
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getStartingY() {
        return startingY;
    }


    private void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(leftReleased);
        keyboard.addEventListener(rightReleased);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                mech.resetTimesBounced();
                break;
            case KeyboardEvent.KEY_LEFT:
                mech.setGoingLeft(true);
                break;
            case KeyboardEvent.KEY_RIGHT:
                mech.setGoingRight(true);
                break;


        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                mech.setGoingLeft(false);
                break;
            case KeyboardEvent.KEY_RIGHT:
                mech.setGoingRight(false);
                mech.setRightBraking(true);
                break;


        }
    }
}
