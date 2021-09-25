import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FrameGame extends JFrame {

    PanelGame pg;
    public FrameGame(PanelGame pg) {
        this.pg =pg;
        setVisible(true);
        setTitle("Game");
        setSize(pg.getPreferredSize());
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        add(pg);
        pack();
    }
}

