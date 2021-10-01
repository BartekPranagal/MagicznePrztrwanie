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
        g.fillRect(5, 5, 200, 50);

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

public void colission(){
    if (game.enemy.getY() + game.enemy.getHeight() >= game.bohater.getY() && ((game.enemy.getX() + game.enemy.getWidth() >= game.bohater.getX() && // tutaj dodałem od Ciebie z asteroid kolizje
            game.enemy.getX() + game.enemy.getWidth() <= game.bohater.getX() + game.bohater.getX()) ||
            (game.enemy.getX() <= game.bohater.getX() + game.bohater.getX() && game.enemy.getX() + game.enemy.getWidth() >= game.bohater.getX()))) {

        JOptionPane.showMessageDialog(this, "Koniec Gry");
        System.exit(0);
    }
    System.out.println(game.bohater.setCurrentHp(game.bohater.getCurrentHp()- EnemyType.FAT.getBaseDmg()));
    repaint();

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

                colission();



            }
        }


    }

}
