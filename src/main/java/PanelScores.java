import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.management.BufferPoolMXBean;

public class PanelScores extends JPanel implements ActionListener {

    private final int width = 400, height = 300;

    private final JLabel scoreLabel;
    private final JButton exitButton, backToGameButton;
    BufferedImage tloWelcome;
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
        try {
            tloWelcome = ImageIO.read(new File("tloWelcome.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(null);

        scoreLabel = new JLabel("Your score:");
        scoreLabel.setBounds(20, 20, 100, 30);
        add(scoreLabel);

        exitButton = new JButton("Exit");
        exitButton.setBounds(100, 200, 80, 50);
        exitButton.addActionListener(this);
        add(exitButton);

        backToGameButton = new JButton("Play again");
        backToGameButton.setBounds(250, 200, 80, 50);
        backToGameButton.addActionListener(this);
        add(backToGameButton);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tloWelcome, 0, 0, getWidth(), getHeight(), null);
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
