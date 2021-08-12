package streetFighter.fighters;

import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

public class Fighter {
    //
    Fighters fighter;
    private int health;
    private int damage;
    private boolean dead;

    private PlayerType playerType;
    private int posX;
    private int posY;
    private int pixelMovement = 30;
    private int jump = 20;
    private int height = 250;
    private int width = 100;
    private int corner = width + height;


    public Fighter(PlayerType playerType, Fighters fighter) {

        this.playerType = playerType;

        this.fighter = fighter;
        this.health = Fighters.getInitialHealth(fighter);
        this.damage = Fighters.getDamage(fighter);
        this.dead = checkIfDead();

        System.out.println(playerType + " " + fighter);

    }

// getters && setters

    public boolean isDead() {
        return dead;
    }

    public int getHealth() {
        return health;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getDamage() {
        return damage;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void moveRight() {
        this.posX = posX + pixelMovement;
    }
    public void moveLeft() {
        this.posX = posX - pixelMovement;
    }
    public void moveUp() { this.posY = posY - 15; }
    public void moveDown() { this.posY = posY + 15; }

    public int getPixelMovement() {
        return pixelMovement;
    }

    public Fighters getFighter() {
        return fighter;
    }
    // methods


    public void hit(int hit) {
        this.health -= hit;
        checkIfDead();
    }

    public boolean checkIfDead() {
        if (health <= 0) {
            this.health = 0;
            return true;
        }
        return false;
    }


}
