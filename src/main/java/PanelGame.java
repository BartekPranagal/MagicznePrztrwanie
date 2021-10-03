import Characters.*;
import Skills.Skill;

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

        for (Enemy e : game.enemies) {
            e.drawEnemy(g, e.getEnemyType(), e.getX(), e.getY(),e.getEnemyType().getWidth(),e.getEnemyType().getHeight());
        }

        for ( Skill s : game.skills) {
//            Graphics2D g2d = (Graphics2D) g;
//            AffineTransform old = g2d.getTransform();
//            g2d.setTransform(AffineTransform.getRotateInstance(Math.toDegrees(Math.atan2(game.bohater.findClosestEnemy(game.enemies).getPosition().x-game.bohater.getPosition().x,game.bohater.findClosestEnemy(game.enemies).getPosition().y-game.bohater.getPosition().y))));
//            g2d.drawImage(s.getSkillImage(),game.bohater.getPosition().x,game.bohater.getPosition().y,s.getWidth(),s.getHeight(),null);
//            g2d.setTransform(old);
            s.drawSkill(g,game.bohater.findClosestEnemy(game.enemies).getPosition().x - game.bohater.getPosition().x,game.bohater.findClosestEnemy(game.enemies).getPosition().y - game.bohater.getPosition().y,s.getWidth(),s.getHeight());
        }


        g.setColor(Color.gray);// pasek zdrowia po prostu jako miejsce na zdrowie, nie ma tutaj max ani min hp
        g.fillRect(5, 5, 200, 50);

        g.setColor(Color.white); // jak stracimy zycie to powoli odsłania się biały pasek
        g.fillRect(5, 5, game.bohater.getMaxHp(), 50);

        g.setColor(Color.green); // pasek zdrowia obecnego
        g.fillRect(5, 5, game.bohater.getCurrentHp(), 50);




    }

    public PanelGame() {

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
        for (Enemy e : game.enemies) {
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

            for (Enemy e : game.enemies) {

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

                if (game.bohater.getCurrentHp() <= 0) {
                    JOptionPane.showMessageDialog(this, "Przegrałeś");
                    System.exit(0);
                }
                repaint();

                for(Skill s : game.skills) {
                    s.setX(s.getX()+s.getDeltaX());
                    s.setY(s.getY()+s.getDeltaY());
                    repaint();
                }


            }
            spawnEnemy();
            System.out.println(game.getSec());
//            System.out.println(game.bohater.findClosestEnemy(game.enemies.));
//            System.out.println(game.bohater.getCurrentHp());
//            System.out.println(game.getNumberOfEnemies());
//            System.out.println(game.enemies.size());

        }


    }

    public void attack(Enemy e) {

        game.bohater.setCurrentHp(game.bohater.getCurrentHp() - e.getBaseDmg());

    }

    public void spawnEnemy() {// nie działa tak jakbym chciał


        if (game.getSec()%3==0)
            game.setNumberOfEnemies(game.getNumberOfEnemies() + 1);

        for (int i = 0; i < game.getNumberOfEnemies() - game.enemies.size(); i++) {

            Enemy temp = game.addRandomEnemy();
            Point p = new Point(getinitialPoints(temp)[(int) (Math.random() * getinitialPoints(temp).length)]);
            temp.setX(p.x);
            temp.setY(p.y);
            game.enemies.add(temp);

        }


    }

    public Point[] getinitialPoints(Enemy e) {

        Point[] points = {
                new Point(0, (int) (Math.random() * (getHeight() - e.getHeight()))),
                new Point(getWidth() - e.getWidth(), ((int) (Math.random() * (getHeight() - e.getHeight())))),
                new Point((int) (Math.random() * (getWidth() - e.getWidth())), 0),
                new Point((int) (Math.random() * (getWidth() - e.getWidth())), (getHeight() - e.getHeight()))
        };

        return points;

    }

}
