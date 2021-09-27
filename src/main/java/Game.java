import Characters.*;


import java.util.ArrayList;
import java.util.List;

public class Game {

    Enemy enemy = new Enemy();
    Hero bohater;

    List<Enemy> enemies = new ArrayList<Enemy>();


    public Game() {

        bohater = new Hero();
        bohater.setX(50);
        bohater.setY(50);
        bohater.setCharWidth(50);
        bohater.setCharHeight(50);
        bohater.setSpeed(5);
    }
}
