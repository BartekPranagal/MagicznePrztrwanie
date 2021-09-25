import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelGame extends JPanel {

    private final int width = 400,height = 600;
    BufferedImage tlo;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(tlo, 0, 0, getWidth(), getHeight(), null);
    }

    public PanelGame(){
        try{
            tlo = ImageIO.read(new File("tlo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
