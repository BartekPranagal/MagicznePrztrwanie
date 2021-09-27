import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FrameGame extends JFrame implements KeyListener, MouseMotionListener {

    int mouseX,mouseY;

    PanelGame pg;
    public FrameGame(PanelGame pg) {
        this.pg =pg;
        setVisible(true);
        setTitle("Game");
        setSize(pg.getPreferredSize());
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        addKeyListener(this);
        add(pg);
        pack();
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_D) { // poruszanie sie w prawo
            if (pg.game.bohater.getX() >= 0 && pg.game.bohater.getX() + pg.game.bohater.getCharWidth() <= pg.getWidth())
                pg.game.bohater.setX(pg.game.bohater.getX() + pg.game.bohater.getSpeed());

            if (pg.game.bohater.getX() + pg.game.bohater.getCharWidth() > pg.getWidth())
                pg.game.bohater.setX(pg.getWidth() - pg.game.bohater.getCharWidth() - 1);

            pg.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) { // poruszanie sie w lewo
            if (pg.game.bohater.getX() >= 0 && pg.game.bohater.getX() + pg.game.bohater.getCharWidth() <= pg.getWidth())
                pg.game.bohater.setX(pg.game.bohater.getX() - pg.game.bohater.getSpeed());

            if (pg.game.bohater.getX() < 0)
                pg.game.bohater.setX(1);

            pg.repaint();
        }

        if(e.getKeyCode() == KeyEvent.VK_S){ // poruszanie sie w dol
            if(pg.game.bohater.getY() >=0 && pg.game.bohater.getY()+pg.game.bohater.getCharHeight() <= pg.getHeight())
                pg.game.bohater.setY(pg.game.bohater.getY()+pg.game.bohater.getSpeed());
            if(pg.game.bohater.getY() < 0)
                pg.game.bohater.setY(1);

            pg.repaint();
        }

        if(e.getKeyCode() == KeyEvent.VK_W){ // poruszanie sie w gore
            if(pg.game.bohater.getY() >=0 && pg.game.bohater.getY()+pg.game.bohater.getCharHeight() <= pg.getHeight())
                pg.game.bohater.setY(pg.game.bohater.getY()-pg.game.bohater.getSpeed());
            if (pg.game.bohater.getY() + pg.game.bohater.getCharHeight() > pg.getHeight())
                pg.game.bohater.setY(pg.getHeight() - pg.game.bohater.getCharHeight() - 1);

            pg.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) { // poruszanie sie w prawo
            if (pg.game.bohater.getX() >= 0 && pg.game.bohater.getX() + pg.game.bohater.getCharWidth() <= pg.getWidth())
                pg.game.bohater.setX(pg.game.bohater.getX() + pg.game.bohater.getSpeed());

            if (pg.game.bohater.getX() + pg.game.bohater.getCharWidth() > pg.getWidth())
                pg.game.bohater.setX(pg.getWidth() - pg.game.bohater.getCharWidth() - 1);

            pg.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) { // poruszanie sie w lewo
            if (pg.game.bohater.getX() >= 0 && pg.game.bohater.getX() + pg.game.bohater.getCharWidth() <= pg.getWidth())
                pg.game.bohater.setX(pg.game.bohater.getX() - pg.game.bohater.getSpeed());

            if (pg.game.bohater.getX() < 0)
                pg.game.bohater.setX(1);

            pg.repaint();
        }

        if(e.getKeyCode() == KeyEvent.VK_S){ // poruszanie sie w dol
            if(pg.game.bohater.getY() >=0 && pg.game.bohater.getY()+pg.game.bohater.getCharHeight() <= pg.getHeight())
                pg.game.bohater.setY(pg.game.bohater.getY()+pg.game.bohater.getSpeed());
            if(pg.game.bohater.getY() < 0)
                pg.game.bohater.setY(1);

            pg.repaint();
        }

        if(e.getKeyCode() == KeyEvent.VK_W){ // poruszanie sie w gore
            if(pg.game.bohater.getY() >=0 && pg.game.bohater.getY()+pg.game.bohater.getCharHeight() <= pg.getHeight())
                pg.game.bohater.setY(pg.game.bohater.getY()-pg.game.bohater.getSpeed());
            if (pg.game.bohater.getY() + pg.game.bohater.getCharHeight() > pg.getHeight())
                pg.game.bohater.setY(pg.getHeight() - pg.game.bohater.getCharHeight() - 1);

            pg.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

