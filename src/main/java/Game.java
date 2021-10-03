import Characters.*;
import Skills.FireBolt;
import Skills.Skill;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Game {

    private int sec = 0;
    private int  score = 0;
    Hero bohater;
    List<Enemy> enemies = new ArrayList<Enemy>();
    List<Enemy> enemiesToRemove = new ArrayList<Enemy>();

    List<Skill> skills = new ArrayList<Skill>();
    List<Skill> skillsToRemove = new ArrayList<Skill>();

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
        bohater.setBaseDmg(70);

    }

    public Enemy addRandomEnemy() {
        return new Enemy(EnemyType.values()[(int)(Math.random()*EnemyType.values().length)]);
    }
    public Skill addFireBolt() {
        return new FireBolt(bohater.getPosition().x,bohater.getPosition().y);
    }

    public ArrayList<Enemy> getEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.addAll(this.enemies);
        return enemies;
    }
    public ArrayList<Skill> getSkills() {
        ArrayList<Skill> skills = new ArrayList<>();
        skills.addAll(this.skills);
        return skills;
    }
    public void enemiesRemoval(){

        for (Enemy e : enemiesToRemove) {
            for (int i = 0; i < enemies.size(); i++) {

                if (e.equals(enemies.get(i)))
                    enemies.remove(i);
            }
        }
    }
    public void countSystem(){
        int timeScore;
        timeScore =  getSec() * 2;
        score = bohater.getCurrentExp() * 3 + timeScore;


    }

}
