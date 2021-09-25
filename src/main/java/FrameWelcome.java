import java.awt.HeadlessException;

import javax.swing.JFrame;

public class FrameWelcome extends JFrame{

    PanelWelcome panel;

    public FrameWelcome(PanelWelcome panel) {
        this.panel = panel;


        setVisible(true);
        setTitle("Login Window");
        setSize(panel.getPreferredSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(panel);
        pack();

    }


}
