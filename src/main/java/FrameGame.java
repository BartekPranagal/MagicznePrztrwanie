import Skills.ElectricShock;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class  FrameGame extends JFrame implements MouseMotionListener, KeyListener {

    int mouseX, mouseY;

    PanelGame pg;
    Music music = new Music();
    public FrameGame(PanelGame pg) {
        this.pg = pg;
        setVisible(true);
        setTitle("Game");
        setSize(pg.getPreferredSize());
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        addMouseMotionListener(this);
        addKeyListener(this);
        add(pg);
        pack();

    }


    @Override
    public void mouseDragged(MouseEvent e) { // podążanie za kursorem
        pg.game.cursor = e.getPoint();

        pg.game.cursor.x -= pg.game.bohater.getWidth() / 2;
        pg.game.cursor.y -= pg.game.bohater.getHeight();

        if (!pg.game.cursor.equals(new Point(pg.game.bohater.getX() + pg.game.bohater.getWidth() / 2, pg.game.bohater.getY() + pg.game.bohater.getHeight() / 2))) {
            Point speedV = new Point(pg.game.bohater.getSpeed(), pg.game.bohater.getSpeed());
            if (pg.game.cursor.x > pg.game.bohater.getX())
                pg.game.bohater.setX(pg.game.bohater.getX() + speedV.x);
            if (pg.game.cursor.x < pg.game.bohater.getX())
                pg.game.bohater.setX(pg.game.bohater.getX() - speedV.x);
            if (pg.game.cursor.y > pg.game.bohater.getY())
                pg.game.bohater.setY(pg.game.bohater.getY() + speedV.y);
            if (pg.game.cursor.y < pg.game.bohater.getY())
                pg.game.bohater.setY(pg.game.bohater.getY() - speedV.y);
        }
        if (pg.game.bohater.getX() < 0) pg.game.bohater.setX(0);
        if (pg.game.bohater.getY() < 0) pg.game.bohater.setY(0);
        if (pg.game.bohater.getX() + pg.game.bohater.getWidth() > pg.getWidth())
            pg.game.bohater.setX(pg.getWidth() - pg.game.bohater.getWidth());
        if (pg.game.bohater.getY() + pg.game.bohater.getHeight() > pg.getHeight())
            pg.game.bohater.setY(pg.getHeight() - pg.game.bohater.getHeight());

        try {
            Thread.sleep(pg.game.bohater.getMovementSpeed());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        pg.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
    boolean isPlayed = false;
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_M){

            music.playSound();
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            pg.game.skills.add(new ElectricShock(pg.game.bohater.getPosition(),pg.game.bohater.findClosestEnemy(pg.game.enemies).getPosition()));
            System.out.println(pg.game.skills.size());
        }
    }
}