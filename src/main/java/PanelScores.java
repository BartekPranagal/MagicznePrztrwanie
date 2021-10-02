import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelScores extends JPanel implements ActionListener {

    private final int width = 400, height = 400;

    private final JLabel scoreLabel;
    private final JButton exitButton, backToGameButton;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PanelScores() {

        setLayout(null);

        scoreLabel = new JLabel("Your score:");
        scoreLabel.setBounds(20, 20, 100, 30);
        add(scoreLabel);

        exitButton = new JButton("Exit");
        exitButton.setBounds(20, 300, 80, 80);
        add(exitButton);

        backToGameButton = new JButton("Play again");
        backToGameButton.setBounds(120, 300, 80, 80);
        add(backToGameButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backToGameButton) {
            Window win = SwingUtilities.getWindowAncestor(this);
            win.dispose();

            FrameGame frameGame = new FrameGame(new PanelGame());
        }

        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}
