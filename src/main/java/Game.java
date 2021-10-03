import Characters.*;
import Skills.Skill;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Game {

    private int sec = 0;
    Hero bohater;
    List<Enemy> enemies = new ArrayList<Enemy>();
    List<Skill> skills = new ArrayList<Skill>();
    Point cursor;
    private int numberOfEnemies = 10;


    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getNumberOfEnemies() {
        return numberOfEnemies;
    }

    public void setNumberOfEnemies(int numberOfEnemies) {
        this.numberOfEnemies = numberOfEnemies;
    }

    public Game() {


        bohater = new Hero();
        bohater.setX(400);
        bohater.setY(400);
        bohater.setWidth(50);
        bohater.setHeight(50);
        bohater.setSpeed(1);
        bohater.setMovementSpeed(16);
        bohater.setMaxHp(200);
        bohater.setCurrentHp(200);


    }

    public Enemy addRandomEnemy() {
        return new Enemy(EnemyType.values()[(int)(Math.random()*EnemyType.values().length)]);
    }


}
