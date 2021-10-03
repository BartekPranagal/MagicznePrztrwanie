package Characters;

import Skills.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero extends Character{ // klasa bohater

    private int currevtLevel = 1;

    private int currentExp;
    private Level level;
    private BufferedImage heroImage;

    private int movementSpeed;
    private Map<String, Skill> magicBook = new HashMap<String, Skill>();
    private Map<Skill, List<Skill>> attacks = new HashMap<Skill, List<Skill>>();
    private boolean isAlive = getCurrentHp() > 0;
    private double attackRange = 300;

    Enemy closestEnemy;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public BufferedImage getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(BufferedImage heroImage) {
        this.heroImage = heroImage;
    }

    public Map<String, Skill> getMagicBook() {
        return magicBook;
    }

    public void setMagicBook(Map<String, Skill> magicBook) {
        this.magicBook = magicBook;
    }

    public Hero() {

        try {
            heroImage = ImageIO.read(new File("postac.png"));
        }catch(Exception e ) {
            e.printStackTrace();
        }
    }

    public void attack() { // atakowanie wrogów


    }

    public Enemy getClosestEnemy() {
        return closestEnemy;
    }

    public void setClosestEnemy(Enemy closestEnemy) {
        this.closestEnemy = closestEnemy;
    }

    public Enemy findClosestEnemy(List<Enemy> enemies) { // szuka najbliższego wroga

        double shortestDistance = 1000000000;
        Enemy closestEnemy = null;

        for (Enemy e : enemies) {
            double currentDistance = (getPosition().distance(e.getPosition()));
                if (currentDistance < shortestDistance){
                    shortestDistance = currentDistance;
                    closestEnemy = e;
                }

        }
        return closestEnemy;



    }


}
