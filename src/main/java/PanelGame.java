import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelGame extends JPanel {

    private final int width = 0, height = 0, dimension = 50;

    BufferedImage tlo;
    Hero bohater = new Hero();
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 600);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(tlo, 0, 0, getPreferredSize().width, getPreferredSize().height, null);
        paintHero(g, bohater.getX(), bohater.getY());
    }
    public void paintHero(Graphics g, int x, int y){
        g.drawImage(bohater.hero, x, y, bohater.getSx(), bohater.getSy(), null);
    }

    public PanelGame() {
        try {
            tlo = ImageIO.read(new File("tlo.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
