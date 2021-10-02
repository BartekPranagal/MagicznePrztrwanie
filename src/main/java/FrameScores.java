import javax.swing.JFrame;
import java.awt.*;

public class FrameScores extends JFrame{
PanelScores panelScores;

    public FrameScores(PanelScores panelScores)  {
        this.panelScores = panelScores;

        setVisible(true);
        setTitle("Result Window");
        setSize(panelScores.getPreferredSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(panelScores);
        pack();
    }
}
