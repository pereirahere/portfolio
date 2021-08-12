package streetFighter.arena;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import streetFighter.*;
import streetFighter.fighters.Fighter;
import streetFighter.inputs.Inputs;
import streetFighter.inputs.ToDo;
import java.util.Timer;
import java.util.TimerTask;


public class Arena implements ToDo {

    private Picture arenaPic;
    private Fighter player1;
    private Fighter player2;
    private Picture picPlayer1;
    private Picture picPlayer2;
    private Picture picPlayer1Punch;
    private Picture picPlayer2Punch;
    private Collider collider;
    private HealthBar hb;
    private String arenaName;
    private String[] player1HitBox = new String[40000];
    private String[] player2HitBox = new String[40000];
    private int jumpDistance;
    private boolean facingInitialPosition = true;
    private boolean fightOver = false;
    private boolean player1Jump = true;
    private boolean player2Jump = true;
    private boolean player1Kickback = false;
    private boolean player2Kickback = false;
    private boolean player1CanAct = true;
    private boolean player2CanAct = true;
    private boolean player1Loop = true;
    private boolean player2Loop = true;
    private boolean isGroundedP1 = false;
    private boolean isGroundedP2 = false;
    private boolean isCollided = false;
    private int player2MoveCooldown = 1;
    private int player1MoveCooldown = 1;
    private int headJumpDistance = 5;
    //private int player1PunchCooldown = 1;
    //private int player2PunchCooldown = 1;



    private Sound punch1 = new Sound("/Resources/Sounding/MovementandFight/punch1.wav");

    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            /*if (player1PunchCooldown > 0) {
                player1PunchCooldown--;
            }
            if (player2PunchCooldown > 0) {
                player2PunchCooldown--;
            }*/
            if (player1MoveCooldown > 0) {
                player1MoveCooldown--;
            }
            if (player2MoveCooldown > 0) {
                player2MoveCooldown--;
            }
        }
    };


    private int teste = 0;
    private final int FIGHTER_REACH = 20;


    //constructor
    public Arena(Fighter player1, Fighter player2, String arenaName) {


        this.arenaName = arenaName;
        Inputs.setInputScreen(this);
        this.player1 = player1;
        this.player2 = player2;
        this.collider = new Collider(this.player1, this.player2, this);
        this.jumpDistance = 15;

        timer.schedule(task, 50, 50);
        init();
    }


    public void init() {
        drawArena();
        player1ThreadJump.start();
        player2ThreadJump.start();
    }

    public void drawArena() {
        arenaPic = new Picture(Game.PADDING, Game.PADDING, arenaName);
        arenaPic.draw();
        hb = new HealthBar(player1, player2);
        drawPlayers();
    }

    public void drawPlayers() {

        player1.setPosX(70);
        player1.setPosY(arenaPic.getHeight() - 200);
        player2.setPosX(arenaPic.getX() + arenaPic.getWidth() - 250);
        player2.setPosY(arenaPic.getHeight() - 200);

        picPlayer1 = new Picture(player1.getPosX(), player1.getPosY(), player1.getFighter().getPhotoName(player1.getFighter()) + "_" + "stand" + "_" + "right.png");
        picPlayer2 = new Picture(player2.getPosX(), player2.getPosY(), player2.getFighter().getPhotoName(player2.getFighter()) + "_" + "stand" + "_" + "left.png");

        picPlayer1Punch = new Picture(player1.getPosX(), player1.getPosY(), player1.getFighter().getPhotoName(player1.getFighter()) + "_" + "punch" + "_" + "right.png");
        picPlayer2Punch = new Picture(player2.getPosX(), player2.getPosY(), player2.getFighter().getPhotoName(player2.getFighter()) + "_" + "punch" + "_" + "left.png");
        //Resources/Fighters/

        picPlayer1.draw();
        picPlayer2.draw();

   /*     boxPos1();
        boxPos2();*/

    }


    public boolean getFacingInitialPosition() {
        return facingInitialPosition;
    }

    ////////////////Keys action PRESSED
    @Override
    public void actionPressed(int key) {

        switch (key) {
            case KeyboardEvent.KEY_W:
                if (isGroundedP1) {
                    player1Jump = true;
                }
                break;

            case KeyboardEvent.KEY_P:
                Runtime.getRuntime().exit(0);
                break;

            case KeyboardEvent.KEY_A:
                if (inBoundsLeft(player1) && player1CanAct && player1Loop && player1MoveCooldown == 0) {
                    if (facingInitialPosition) {
                        picPlayer1.translate(-player1.getPixelMovement(), 0);
                        picPlayer1Punch.translate(-player1.getPixelMovement(), 0);
                        player1.moveLeft();
                        player1MoveCooldown = 1;
                    }
                    if (!facingInitialPosition && !isCollided) {
                        picPlayer1.translate(-player1.getPixelMovement(), 0);
                        picPlayer1Punch.translate(-player1.getPixelMovement(), 0);
                        player1.moveLeft();
                        player1MoveCooldown = 1;
                    }

                }
                break;

            case KeyboardEvent.KEY_D:
                if (inBoundsRight(player1) && player1CanAct && player1Loop && player1MoveCooldown == 0) {
                    if (facingInitialPosition && !isCollided) {
                        picPlayer1.translate(player1.getPixelMovement(), 0);
                        picPlayer1Punch.translate(player1.getPixelMovement(), 0);
                        player1.moveRight();
                        player1MoveCooldown = 1;
                    }
                    if (!facingInitialPosition) {
                        picPlayer1.translate(player1.getPixelMovement(), 0);
                        picPlayer1Punch.translate(player1.getPixelMovement(), 0);
                        player1.moveRight();
                        player1MoveCooldown = 1;
                    }
                }
                break;

            case KeyboardEvent.KEY_UP:
                if (isGroundedP2) {
                    player2Jump = true;
                    //player2JumpCooldown = 1;
                }
                break;

            case KeyboardEvent.KEY_LEFT:

                if (inBoundsLeft(player2) && player2CanAct && player2Loop && player2MoveCooldown == 0) {
                    if (facingInitialPosition && !isCollided) {
                        picPlayer2.translate(-player2.getPixelMovement(), 0);
                        picPlayer2Punch.translate(-player2.getPixelMovement(), 0);
                        player2.moveLeft();
                        player2MoveCooldown = 1;
                    }

                    if (!facingInitialPosition) {
                        picPlayer2.translate(-player2.getPixelMovement(), 0);
                        picPlayer2Punch.translate(-player2.getPixelMovement(), 0);
                        player2.moveLeft();
                        player2MoveCooldown = 1;
                    }

                }
                break;

            case KeyboardEvent.KEY_RIGHT:

                if (inBoundsRight(player2) && player2CanAct && player2Loop && player2MoveCooldown == 0) {
                    if (facingInitialPosition) {
                        picPlayer2.translate(player2.getPixelMovement(), 0);
                        picPlayer2Punch.translate(player2.getPixelMovement(), 0);
                        player2.moveRight();
                        player2MoveCooldown = 1;
                    }

                    if (!facingInitialPosition && !isCollided) {
                        picPlayer2.translate(player2.getPixelMovement(), 0);
                        picPlayer2Punch.translate(player2.getPixelMovement(), 0);
                        player2.moveRight();
                        player2MoveCooldown = 1;
                    }

                }
                break;

            case KeyboardEvent.KEY_1:
                if (player1CanAct && player1Loop) {
                    picPlayer1Punch.draw();
                    picPlayer1.delete();
                    // player1PunchCooldown = 1;
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                if (player2CanAct && player2Loop) {
                    picPlayer2Punch.draw();
                    picPlayer2.delete();
                    //player2PunchCooldown = 1;
                }
                break;
        }

        useCollider();
        setFacingPosition();
        reverse();
    }

    ///////////// action RELEASED
    @Override
    public void actionReleased(int key) {
        switch (key) {
            case KeyboardEvent.KEY_1:
                if (player1CanAct && player1Loop) {
                    picPlayer1.draw();
                    picPlayer1Punch.delete();
                    hitInTheFace(player1, player2);
                }
                break;

            case KeyboardEvent.KEY_SPACE:

                if (player2CanAct && player2Loop) {
                    picPlayer2.draw();
                    picPlayer2Punch.delete();
                    hitInTheFace(player2, player1);
                }
                break;
        }
    }

///////////////////// Metodos

    private void reverse() {
        if (facingInitialPosition) {
            picPlayer1.load(player1.getFighter().getPhotoName(player1.getFighter()) + "_" + "stand" + "_" + "right.png");
            picPlayer2.load(player2.getFighter().getPhotoName(player2.getFighter()) + "_" + "stand" + "_" + "left.png");
            picPlayer1Punch.load(player1.getFighter().getPhotoName(player1.getFighter()) + "_" + "punch" + "_" + "right.png");
            picPlayer2Punch.load(player2.getFighter().getPhotoName(player2.getFighter()) + "_" + "punch" + "_" + "left.png");
        } else {
            picPlayer1.load(player1.getFighter().getPhotoName(player1.getFighter()) + "_" + "stand" + "_" + "left.png");
            picPlayer2.load(player2.getFighter().getPhotoName(player2.getFighter()) + "_" + "stand" + "_" + "right.png");
            picPlayer1Punch.load(player1.getFighter().getPhotoName(player1.getFighter()) + "_" + "punch" + "_" + "left.png");
            picPlayer2Punch.load(player2.getFighter().getPhotoName(player2.getFighter()) + "_" + "punch" + "_" + "right.png");

        }
    }

    public void useCollider() {
        isCollided = collider.checkCollision();
    }


    public void deleteAll() {
        arenaPic.delete();
        picPlayer1.delete();
        picPlayer2.delete();
        picPlayer1Punch.delete();
        picPlayer2Punch.delete();
        hb.healthBarDelete();
    }
    private boolean inBoundsRight(Fighter player) {
        if ((player.getPosX() + player.getWidth() > arenaPic.getX() + arenaPic.getWidth() - (Game.BORDER + player.getWidth()))) {
            return false;
        }
        return true;
    }

    private boolean inBoundsLeft(Fighter player) {
        if (player.getPosX() < arenaPic.getX() + Game.BORDER * 2) {
            return false;
        }
        return true;
    }

    private void hitInTheFace(Fighter playerPuncher, Fighter playerPuncherReceiver) {
        if (playerPuncher == player1 && isCollided) {
            playerPuncherReceiver.hit(playerPuncher.getDamage());
            punch1.play(true);
            whoKicksback();

        }
        if (playerPuncher == player2 && isCollided) {
            playerPuncherReceiver.hit(playerPuncher.getDamage());
            punch1.play(true);
            whoKicksback();
        }
        hb.healthBarDelete();
        hb = new HealthBar(player1, player2);
        checkIfDead();
    }

    private void checkIfDead() {

        if (player1.checkIfDead()) {
            fightOver = true;
            System.out.println("player 2 won");

            player1Loop = false;
            player2Loop = false;
            new GameOverScreen(2, this);
        }

        if (player2.checkIfDead()) {
            fightOver = true;
            System.out.println("Player 1 won");
            player1CanAct = true;
            player1Loop = false;
            player2Loop = false;
            new GameOverScreen(1, this);
        }

    }

    private void setFacingPosition() {
        if (player2.getPosX() - (player1.getPosX() + player1.getWidth()) <= -50) {
            facingInitialPosition = false;
        }

        if (player1.getPosX() - (player2.getPosX() + player2.getWidth()) <= -50) {
            facingInitialPosition = true;
        }
    }


    public void goUp1() {
        player1CanAct = false;
        useCollider();
        try{
        picPlayer1.translate(0, -jumpDistance);
        picPlayer1Punch.translate(0, -jumpDistance);}
        catch (java.util.ConcurrentModificationException e) {
            System.out.println("CMExc");
        }
        player1.moveUp();
        player1CanAct = true;
    }

    public void player1Gravity() {
        if (picPlayer1.getY() + picPlayer1.getHeight() <= arenaPic.getHeight() - 50) {
            player1CanAct = false;
            isGroundedP1 = false;
            try {
            picPlayer1.translate(0, jumpDistance);
            picPlayer1Punch.translate(0, jumpDistance); }
            catch (java.util.ConcurrentModificationException e) {
                System.out.println("CMExc");
            }
            player1.moveDown();
            player1CanAct = true;
            return;
        }
        isGroundedP1 = true;
    }

    public void player1Kickback() {
        player1CanAct = false;

        if (facingInitialPosition) {
            try{
            picPlayer1.translate(-player1.getPixelMovement(), 0);
            picPlayer1Punch.translate(-player1.getPixelMovement(), 0);}
            catch (java.util.ConcurrentModificationException e) {
                System.out.println("CMExc");
            }
            player1.moveLeft();
        }

        if (!facingInitialPosition) {
            try{
            picPlayer1.translate(player2.getPixelMovement(), 0);
            picPlayer1Punch.translate(player2.getPixelMovement(), 0);}
            catch (java.util.ConcurrentModificationException e) {
                System.out.println("CMExc");
            }
            player1.moveRight();
        }

    }

    public void goUp2() {
        player2CanAct = false;
        useCollider();
        try{
        picPlayer2.translate(0, -jumpDistance);
        picPlayer2Punch.translate(0, -jumpDistance);}
        catch (java.util.ConcurrentModificationException e) {
            System.out.println("CMExc");
        }
        player2.moveUp();
        player2CanAct = true;
    }

    public void player2Gravity() {
        if (picPlayer2.getY() + picPlayer2.getHeight() <= arenaPic.getHeight() - 50) {
            player2CanAct = false;
            isGroundedP2 = false;
            try {
            picPlayer2.translate(0, jumpDistance);
            picPlayer2Punch.translate(0, jumpDistance); }
            catch (java.util.ConcurrentModificationException e) {
                System.out.println("CMExc");
            }
            player2.moveDown();
            player2CanAct = true;
            return;
        }
        isGroundedP2 = true;
    }

    public void player2Kickback() {
        player2CanAct = false;
        if (facingInitialPosition) {
            try{
            picPlayer2.translate(player2.getPixelMovement(), 0);
            picPlayer2Punch.translate(player2.getPixelMovement(), 0);}
            catch (java.util.ConcurrentModificationException e) {
                System.out.println("CMExc");
            }
            player2.moveRight();
        }

        if (!facingInitialPosition) {
            try{
            picPlayer2.translate(-player1.getPixelMovement(), 0);
            picPlayer2Punch.translate(-player1.getPixelMovement(), 0);}
            catch (java.util.ConcurrentModificationException e) {
                System.out.println("CMExc");
            }
            player2.moveLeft();
        }

    }

    public void whoKicksback() {
        if (facingInitialPosition) {
            if (player1.getPosX() + player1.getWidth() >= arenaPic.getWidth() / 2) {
                player1Kickback = true;
                return;
            }

            if (player2.getPosX() <= arenaPic.getWidth() / 2) {
                player2Kickback = true;
                return;
            }
        }

        if (!facingInitialPosition) {
            if (player1.getPosX() + player1.getWidth() >= arenaPic.getWidth() / 2) {
                player2Kickback = true;
                return;
            }

            if (player2.getPosX() <= arenaPic.getWidth() / 2) {
                player1Kickback = true;
                return;
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
//Threads
    Thread player1ThreadJump = new Thread(new Runnable() {

        void jump() {
            for (int i = 0; i < 20; i++) {
                goUp1();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        void callKickback() {
            for (int i = 0; i < 5; i++) {
                player1Kickback();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            player1Kickback = false;
        }

        void callGravity() {
            player1Gravity();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            while (player1Loop) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (player1Jump) {
                    jump();
                    player1Jump = false;
                }
                if (player1Kickback) {
                    callKickback();
                    player1CanAct = true;
                }
                callGravity();
            }
        }
    });

    Thread player2ThreadJump = new Thread(new Runnable() {
        void jump() {
            for (int i = 0; i < 20; i++) {
                goUp2();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        void callKickback() {
            for (int i = 0; i < 5; i++) {
                player2Kickback();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            player2Kickback = false;
        }

        void callGravity() {
            player2Gravity();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (player2Loop) {

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (player2Jump) {
                    jump();
                    player2Jump = false;
                }
                if (player2Kickback) {
                    callKickback();
                    player2CanAct = true;
                }
                callGravity();
            }
        }
    });

}
