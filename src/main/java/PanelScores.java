import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelScores extends JPanel implements ActionListener {
    Game game;
    private final int width = 400, height = 400;

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
        game = new Game();
        try {
            tloWelcome = ImageIO.read(new File("tloWelcome.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);


        scoreLabel = new JLabel("Your score:" + String.valueOf(game.score)); // wywala wynik 0.
        scoreLabel.setBounds(20, 20, 100, 30);
        add(scoreLabel);

        exitButton = new JButton("Exit");
        exitButton.setBounds(20, 300, 80, 80);
        exitButton.addActionListener(this);
        add(exitButton);

        backToGameButton = new JButton("Play again");
        backToGameButton.setBounds(120, 300, 80, 80);
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
