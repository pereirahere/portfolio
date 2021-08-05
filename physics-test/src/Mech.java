public class Mech {


    public static final int PADDING = 10;

    private Ground ground;
    private Subject subject;
    private Floor floor;

    private double bounceSpeed;
    private double gravitySpeed;
    private double distanceToBounce;

    private int xIr;
    private int xIl;
    private int xIr2;
    private int xIl2;

    private int xSpeed;
    private int timesBounced;
    private int temp = 0;

    private Thread masterThread;

    private boolean masterFlag;
    private boolean gravityFlag;
    private boolean isBouncing;
    private boolean goingLeft;
    private boolean goingRight;
    private boolean rightBraking;
    private boolean leftBraking;
    private boolean rightKicking;
    private boolean leftKicking;

    public void init() {

        System.out.println("TESTS ARE STARTING");
        ground = new Ground();
        subject = new Subject(225, 0, 50, 50, this);
        floor = new Floor();

        masterFlag = true;
        gravityFlag = true;
        isBouncing = false;
        goingLeft = false;
        goingRight = false;
        rightBraking = false;
        leftBraking = false;
        rightKicking = false;
        leftKicking = false;

        timesBounced = 0;
        bounceSpeed = -20;
        gravitySpeed = 10;
        xSpeed = 10;
        temp = 0;
        xIr = xSpeed - 1;
        xIl = xSpeed - 1;
        xIr2 = xSpeed * 4;
        xIl2 = xSpeed * 4;

        distanceToBounce = subject.getStartingY() + ground.getHeight() / 2;

        masterThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    subjectPhysics();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        masterThread.start();

    }

    public void subjectPhysics() throws InterruptedException {

        while (masterFlag) {

            Thread.sleep(1);

            while (gravityFlag) {

                if (!isBouncing) {
                    gravity();
                }
                if (isBouncing) {
                    bounce();
                }

                if (goingLeft) {
                    pushXleft();
                }

                if (goingRight) {
                    pushXright();
                }

                if (rightBraking) {
                    brakeRight();
                }

                if (leftBraking) {
                    brakeLeft();
                }

                if (rightKicking) {
                    kickRight();
                }

                if (leftKicking) {
                    kickLeft();
                }

                Thread.sleep(25);

            }

        }

    }

    public void kickRight() {

        subject.pushX(-xIr2);
        xIr2 -= 1;
        if (xIr2 <= 0) {
            rightKicking = false;
            xIr2 = xSpeed * 4;
        }

    }

    public void kickLeft() {

        subject.pushX(xIl2);
        xIl2 -= 1;
        if (xIl2 < 0) {
            leftKicking = false;
            xIl2 = xSpeed * 4;
        }

    }


    public void pushXleft() {

        if (subject.getX() >= PADDING) {
            subject.pushX(-xSpeed);
            leftBraking = true;
            return;
        }

        leftKicking = true;
    }

    public void pushXright() {

        if (subject.getX() < ground.getWidth() - 50) {
            subject.pushX(xSpeed);
            rightBraking = true;
            return;
        }

        rightKicking = true;
    }

    public void brakeRight() {
        subject.pushX(xIr);
        xIr -= 1;
        if (xIr <= 0) {
            rightBraking = false;
            xIr = xSpeed - 1;
        }
    }

    public void brakeLeft() {
        subject.pushX(-xIl);
        xIl -= 1;
        if (xIl <= 0) {
            leftBraking = false;
            xIl = xSpeed - 1;
        }
    }

    public void gravity() {

        if (subject.getY() + floor.getHeight() / 2 + PADDING <= floor.getY()) {
            gravitySpeed++;
            subject.pushY(gravitySpeed);
            return;
        }

        if (timesBounced == 0) {
            isBouncing = true;
        }

    }


    public void bounce() {

        bounceSpeed++;
        subject.pushY(bounceSpeed);

        if (subject.getY() + floor.getHeight() / 2 >= floor.getY() && timesBounced >= 1) {
            temp += 5;
            bounceSpeed = -25 + temp;
        }

        if (temp == 25) {
            isBouncing = false;
            temp = 0;
            return;
        }

        timesBounced++;

    }

    public void setBouncing(boolean isBouncing) {
        this.isBouncing = isBouncing;
    }

    public void resetTimesBounced() {
        timesBounced = 0;
    }

    public void setGoingLeft(boolean goingLeft) {
        this.goingLeft = goingLeft;
    }

    public void setGoingRight(boolean goingRight) {
        this.goingRight = goingRight;
    }

    public boolean isGoingRight() {
        return goingRight;
    }

    public boolean isGoingLeft() {
        return goingLeft;
    }

    public void setRightBraking(boolean rightBraking) {
        this.rightBraking = rightBraking;
    }

}
