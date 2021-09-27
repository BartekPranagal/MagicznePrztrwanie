import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelGame extends JPanel {

    Game game = new Game();

    private final int width = 1000,height = 800;
    BufferedImage tlo;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(tlo, 0, 0, getWidth(), getHeight(), null);
        paintHero(g,0,0);
    }

    public PanelGame(){
        try{
            tlo = ImageIO.read(new File("tlo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paintHero(Graphics g, int x, int y){
        g.drawImage(game.bohater.getHeroImage(), x, y, game.bohater.getCharWidth(), game.bohater.getCharHeight(), null);
    }

}
