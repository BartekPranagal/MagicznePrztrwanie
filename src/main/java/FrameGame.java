import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FrameGame extends JFrame implements KeyListener {

    PanelGame pg;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) { // poruszanie sie w prawo
            if (pg.bohater.getX() >= 0 && pg.bohater.getX() + pg.bohater.getSx() <= pg.getWidth())
                pg.bohater.setX(pg.bohater.getX() + 20);

            if (pg.bohater.getX() + pg.bohater.getSx() > pg.getWidth())
                pg.bohater.setX(pg.getWidth() - pg.bohater.getSx() - 1);

            pg.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) { // poruszanie sie w lewo
            if (pg.bohater.getX() >= 0 && pg.bohater.getX() + pg.bohater.getSx() <= pg.getWidth())
                pg.bohater.setX(pg.bohater.getX() - 20);

            if (pg.bohater.getX() < 0)
                pg.bohater.setX(1);

            pg.repaint();
        }

        if(e.getKeyCode() == KeyEvent.VK_S){ // poruszanie sie w dol
            if(pg.bohater.getY() >=0 && pg.bohater.getY()+pg.bohater.getSy() <= pg.getHeight())
                pg.bohater.setY(pg.bohater.getY()+20);
            if(pg.bohater.getY() < 0)
                pg.bohater.setY(1);

            pg.repaint();
        }

        if(e.getKeyCode() == KeyEvent.VK_W){ // poruszanie sie w gore
            if(pg.bohater.getY() >=0 && pg.bohater.getY()+pg.bohater.getSy() <= pg.getHeight())
                pg.bohater.setY(pg.bohater.getY()-20);
            if (pg.bohater.getY() + pg.bohater.getSy() > pg.getHeight())
                pg.bohater.setY(pg.getHeight() - pg.bohater.getSy() - 1);

            pg.repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public FrameGame(PanelGame pg) {

        addKeyListener(this);
        this.pg = pg;
        setVisible(true);
        setTitle("Game");
        setSize(pg.getPreferredSize());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(pg);
        pack();
    }

}

