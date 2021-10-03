import Characters.*;
import Skills.FireBolt;
import Skills.Skill;
import org.postgresql.gss.GSSOutputStream;
import org.w3c.dom.ls.LSOutput;

import java.awt.geom.AffineTransform;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

public class PanelGame extends JPanel {

    Game game;

    private final int width = 1000, height = 800;
    private BufferedImage tlo;
    Music music = new Music();
    Timer timer = new Timer();

    TimerTask timeCounter;


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(tlo, 0, 0, getWidth(), getHeight(), null);

        paintHero(g, game.bohater.getX(), game.bohater.getY());

        for (Enemy e : game.getEnemies()) {
           e.drawEnemy(g,e.getEnemyType(),e.getX(),e.getY(),e.getWidth(),e.getHeight());
        }

        for ( Skill s : game.getSkills()) {
//            Graphics2D g2d = (Graphics2D) g;
//            AffineTransform old = g2d.getTransform();
//            g2d.setTransform(AffineTransform.getRotateInstance(Math.toDegrees(Math.atan2(game.bohater.findClosestEnemy(game.enemies).getPosition().x-game.bohater.getPosition().x,game.bohater.findClosestEnemy(game.enemies).getPosition().y-game.bohater.getPosition().y))));
//            g2d.drawImage(s.getSkillImage(),game.bohater.getPosition().x,game.bohater.getPosition().y,s.getWidth(),s.getHeight(),null);
//            g2d.setTransform(old);
            s.drawSkill(g,s.getX(),s.getY(),s.getWidth(),s.getHeight());
        }

        g.setColor(Color.BLUE);
        g.drawString("HP:", 5, 25);
        g.setColor(Color.gray);// pasek zdrowia po prostu jako miejsce na zdrowie, nie ma tutaj max ani min hp
        g.fillRect(35, 5, 200, 25);
        g.setColor(Color.red); // jak stracimy zycie to powoli odsłania się biały pasek
        g.fillRect(35, 5, game.bohater.getMaxHp(), 25);
        g.setColor(Color.green); // pasek zdrowia obecnego
        g.fillRect(35, 5, game.bohater.getCurrentHp(), 25);

        g.setColor(Color.BLUE);
        g.drawString("EXP:",5 , 55);
        g.setColor(Color.magenta); // // pasek expa pustego
        g.fillRect(35, 35, 200, 25);
        g.setColor(Color.YELLOW); // // pasek expa
        g.fillRect(35, 35, game.bohater.getCurrentExp(), 25);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(game.bohater.getLevel()), 125, 55);
        g.setColor(Color.BLACK); // dodanie ze pokazuje jak sie nabijaja punkty.
        g.drawString(String.valueOf(game.countSystem()),100,100);

    }



    public PanelGame() {

       // music.playSound();
        game = new Game();

        timeCounter = new TimerTask() {
            @Override
            public void run() {
                game.setSec(game.getSec() + 1);
            }
        };
        timer.scheduleAtFixedRate(timeCounter, 0, 1000);

        try {

            tlo = ImageIO.read(new File("tlo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Enemy e : game.getEnemies()) {
            try {
                e.setEnemyImage(ImageIO.read(new File(e.getEnemyType().getPath())));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }



        new Thread(() -> animation()).start();
    }

    public void paintHero(Graphics g, int x, int y) {
        g.drawImage(game.bohater.getHeroImage(), x, y, game.bohater.getWidth(), game.bohater.getHeight(), null);
    }

    public void animation() { // metoda odpowiedzialna za animacje

        while (true) {
            game.bohater.findClosestEnemy(game.enemies);
            spawnEnemy();

            for (Enemy e : game.getEnemies()) {

                Point heroP = new Point(game.bohater.getX() + game.bohater.getWidth() / 2, game.bohater.getY() + game.bohater.getHeight() / 2);
                Point enemyP = new Point(e.getX() + e.getWidth() / 2, e.getY() + e.getHeight() / 2);

                if (!enemyP.equals(heroP)) { // poruszanie się wrogów

                    if (enemyP.x > heroP.x)
                        e.setX(e.getX() - e.getSpeed());
                    if (enemyP.x < heroP.x)
                        e.setX(e.getX() + e.getSpeed());
                    if (enemyP.y > heroP.y)
                        e.setY(e.getY() - e.getSpeed());
                    if (enemyP.y < heroP.y)
                        e.setY(e.getY() + e.getSpeed());

                    try {
                        Thread.sleep(5);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
                if (game.bohater.getBounds().intersects(e.getBounds()) && game.getSec()%2==0) {
                    attack(e);
                }

            }
            repaint();
//            System.out.println(game.bohater.findClosestEnemy(game.enemies).getEnemyType().getName());




            for (Skill s : game.getSkills()) {
                if(!s.isDirectionSet()) {
                    int x = game.bohater.findClosestEnemy(game.enemies).getX() + game.bohater.findClosestEnemy(game.enemies).getWidth() / 2;
                    int y = game.bohater.findClosestEnemy(game.enemies).getY() + game.bohater.findClosestEnemy(game.enemies).getHeight() / 2;

                    Point skillP = new Point(s.getX() + s.getWidth() / 2, s.getY() + s.getHeight() / 2);

                    if (skillP.x > x)
                        s.setVelX(s.getSpeed()*(-1));
                        s.setX(s.getX()+s.getVelX());
                    if (skillP.x < x)
                        s.setVelX(s.getSpeed());
                        s.setX(s.getX()+s.getVelX());
                    if (skillP.y > y)
                        s.setVelY(s.getSpeed()*(-1));
                        s.setY(s.getY()+s.getVelY());
                    if (skillP.y < y)
                        s.setVelY(s.getSpeed());
                        s.setY(s.getY()+s.getVelY());

                    s.setDirectionSet(true);
                } else {
                    s.setX(s.getX()+s.getVelX());
                    s.setY(s.getY()+s.getVelY());

                }
                    try {
                        Thread.sleep(4);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }


            }

            repaint();

            for (Skill s : game.getSkills()) {
                for (Enemy e : game.getEnemies()) {

                    if(s.getBounds().intersects(e.getBounds())) {
                        game.skillsToRemove.add(s);
                        e.setCurrentHp(e.getCurrentHp() - s.getDmg());
                        System.out.println(e.getCurrentHp());
                        game.skillsRemoval();

                    }
                }

            }


            for(Enemy e : game.getEnemies()) {
                if(e.getCurrentHp() <=0) {
                    game.enemiesToRemove.add(e);
                    game.bohater.setCurrentExp(game.bohater.getCurrentExp()+e.getEnemyType().getExpValue());
                    game.enemiesRemoval();
                }
            }

            if (game.bohater.getCurrentHp() <= 0) {
                Window win = SwingUtilities.getWindowAncestor(this);
                win.dispose();
                FrameScores scoresGame = new FrameScores(new PanelScores());
                break;
            }

            if(game.bohater.getCurrentExp()>=game.bohater.getLevel().getExpRequired(game.bohater.getCurrentLevel())){
                game.bohater.setCurrentLevel(+1);
                System.out.println(game.bohater.getCurrentLevel());

            }


        }

        repaint();

        game.countSystem();
    }

    public void attack(Enemy e) {

        game.bohater.setCurrentHp(game.bohater.getCurrentHp() - e.getBaseDmg());
        e.setCurrentHp(e.getCurrentHp() - game.bohater.getBaseDmg());
        System.out.println(e.getCurrentHp());


    }

    public void getScore(){
        int wynik =0;

    }


    public void spawnEnemy() {

        if (game.getSec()%5==0)
            game.setNumberOfEnemies(game.getNumberOfEnemies() + 1);

        for (int i = 0; i < game.getNumberOfEnemies() - game.enemies.size(); i++) {

            Enemy temp = game.addRandomEnemy();
            Point p = new Point(getInitialPoints(temp)[(int) (Math.random() * getInitialPoints(temp).length)]);
            temp.setX(p.x);
            temp.setY(p.y);
            game.enemies.add(temp);

        }


    }


    public Point[] getInitialPoints(Enemy e) {

        Point[] points = {
                new Point(0, (int) (Math.random() * (getHeight() - e.getHeight()))),
                new Point(getWidth() - e.getWidth(), ((int) (Math.random() * (getHeight() - e.getHeight())))),
                new Point((int) (Math.random() * (getWidth() - e.getWidth())), 0),
                new Point((int) (Math.random() * (getWidth() - e.getWidth())), (getHeight() - e.getHeight()))
        };

        return points;

    }

}
