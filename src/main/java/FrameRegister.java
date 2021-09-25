import java.awt.HeadlessException;

import javax.swing.JFrame;

public class FrameRegister extends JFrame{
    PanelRegister pr;

    public FrameRegister(PanelRegister pr) {
        this.pr = pr;

        setVisible(true);
        setTitle("Registration Window");
        setSize(pr.getPreferredSize());
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        add(pr);
        pack();
    }


}
