import Characters.Enemy;
import Characters.EnemyType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelGame extends JPanel {

    Game game;
    EnemyType enemyType;
    private final int width = 1000, height = 800;
    BufferedImage tlo;


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.drawImage(tlo, 0, 0, getWidth(), getHeight(), null);

        g.setColor(Color.gray);// pasek zdrowia po prostu jako miejsce na zdrowie, nie ma tutaj max ani min hp
        g.fillRect(5, 5, 200, 50);

        g.setColor(Color.white); // jak stracimy zycie to powoli odsłania się biały pasek
        g.fillRect(5, 5, 200, 50);

        g.setColor(Color.green); // pasek zdrowia obecnego
        g.fillRect(5, 5, game.bohater.getCurrentHp(), 50);

        paintHero(g, game.bohater.getX(), game.bohater.getY());

        for (Enemy e : game.enemies) {
            e.drawEnemy(g, e.getEnemyType(), e.getX(), e.getY());
        }
    }

    public PanelGame() {
        game = new Game();

        try {
            tlo = ImageIO.read(new File("tlo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(() -> animation()).start();

    }

    public void paintHero(Graphics g, int x, int y) {
        g.drawImage(game.bohater.getHeroImage(), x, y, game.bohater.getWidth(), game.bohater.getHeight(), null);
    }

    public synchronized void animation() { // metoda odpowiedzialna za animacje na ekrnaie,ruch wrogów


        while (true) {

            for (Enemy e : game.enemies) { // poruszanie się wrogów

                Point heroP = new Point(game.bohater.getX() + game.bohater.getWidth() / 2, game.bohater.getY() + game.bohater.getHeight() / 2);
                Point enemyP = new Point(e.getX() + e.getWidth() / 2, e.getY() + e.getHeight() / 2);

                if (!enemyP.equals(heroP)) {

                    if (enemyP.x > heroP.x)
                        e.setX(e.getX() - e.getSpeed());
                    if (enemyP.x < heroP.x)
                        e.setX(e.getX() + e.getSpeed());
                    if (enemyP.y > heroP.y)
                        e.setY(e.getY() - e.getSpeed());
                    if (enemyP.y < heroP.y)
                        e.setY(e.getY() + e.getSpeed());

                    try {
                        Thread.sleep(10);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }

                if (game.bohater.getBounds().intersects(e.getBounds())) {

                    attack(e);
                }
                if (game.bohater.getCurrentHp() <=0 ) {
                    JOptionPane.showMessageDialog(this, "Przegrałeś");
                    System.exit(0);
                }
                repaint();


            }
            spawnEnemy();
//            System.out.println(game.bohater.findClosestEnemy(game.enemies.));
//            System.out.println(game.bohater.getCurrentHp());
//            System.out.println(game.getNumberOfEnemies());
//            System.out.println(game.enemies.size());

        }


    }

    public synchronized void attack(Enemy e) {
        try {
            Thread attack = new Thread("attack");
            attack.start();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        game.bohater.setCurrentHp(game.bohater.getCurrentHp() - e.getBaseDmg());

    }

    public synchronized void spawnEnemy() {// nie działa tak jakbym chciał


        try {
            Thread spawn = new Thread("spawn");
            spawn.join(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        game.setNumberOfEnemies(game.getNumberOfEnemies() + 1);

        for (int i = 0; i < game.getNumberOfEnemies() - game.enemies.size(); i++) {

            Enemy temp = game.addRandomEnemy();
            Point p = new Point(getinitialPoints(temp)[(int) (Math.random()*getinitialPoints(temp).length)]);
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
