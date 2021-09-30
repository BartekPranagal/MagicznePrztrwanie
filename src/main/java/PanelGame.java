import Characters.Enemy;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelGame extends JPanel {

    Game game;

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
            for (Enemy e : game.enemies) {
                Point heroP = new Point(game.bohater.getX()+ game.bohater.getWidth()/2, game.bohater.getY()+ game.bohater.getHeight()/2);
                Point enemyP = new Point(e.getX()+e.getWidth()/2, e.getY()+ e.getHeight()/2);
                if (!enemyP.equals(heroP)) {

                    Point movementVector = new Point(1, 1);
                    if (enemyP.x > heroP.x) e.setX(e.getX() - e.getSpeed());
                    if (enemyP.x < heroP.x) e.setX(e.getX() + e.getSpeed());
                    if (enemyP.y > heroP.y) e.setY(e.getY() - e.getSpeed());
                    if (enemyP.y < heroP.y) e.setY(e.getY() + e.getSpeed());

                    try {
                        Thread.sleep(5);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
                repaint();


            }
        }


    }

}
