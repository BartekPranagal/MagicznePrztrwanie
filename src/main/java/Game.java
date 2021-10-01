import Characters.*;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    EnemyType enemyType;
    Enemy enemy = new Enemy();
    Hero bohater;
    List<Enemy> enemies = new ArrayList<Enemy>();
    Point cursor;



    public Game() {

        bohater = new Hero();
        bohater.setX(400);
        bohater.setY(400);
        bohater.setWidth(50);
        bohater.setHeight(50);
        bohater.setSpeed(2);
        bohater.setMovementSpeed(10);
        bohater.setMaxHp(200);
        bohater.setCurrentHp(200);
        sampleEnemies();
    }

    public void sampleEnemies() {

        enemies.add(new Enemy(EnemyType.FAT));
        enemies.add(new Enemy(EnemyType.NORMAL));
        enemies.add(new Enemy(EnemyType.DIVIDER));
        enemies.add(new Enemy(EnemyType.SPEEDY));
        enemies.add(new Enemy(EnemyType.KABOOM));
        enemies.add(new Enemy(EnemyType.SPEEDY));
        enemies.add(new Enemy(EnemyType.SPEEDY));
        enemies.add(new Enemy(EnemyType.SPEEDY));




    }

}
