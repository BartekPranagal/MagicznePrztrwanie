import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class PanelWelcome extends JPanel implements ActionListener {

    private final int width = 300, height = 300;

    private final JLabel loginLabel, passwordLabel;
    private final JTextField loginField;
    private final JPasswordField passwordField;
    private final JButton loginButton, registerButton, playAsGuestButton, musicButton;
    private final JRadioButton showPasswordButton;
    Music muzyka = new Music();
    BufferedImage tloWelcome;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tloWelcome, 0, 0, getWidth(), getHeight(), null);
    }

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

    public PanelWelcome() {
        try {
            tloWelcome = ImageIO.read(new File("tloWelcome.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);

        loginLabel = new JLabel("Login: ");
        loginLabel.setBounds(20, 20, 100, 30);
        add(loginLabel);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(20, 60, 100, 30);
        add(passwordLabel);

        loginField = new JTextField();
        loginField.setBounds(125, 20, 100, 30);
        add(loginField);

        passwordField = new JPasswordField();
        passwordField.setBounds(125, 60, 100, 30);
        passwordField.setEchoChar('*');
        add(passwordField);

        showPasswordButton = new JRadioButton("Show Password");
        showPasswordButton.setBounds(125, 90, 150, 15);
        showPasswordButton.addActionListener(this);
        add(showPasswordButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 115, 200, 40);
        loginButton.addActionListener(this);
        add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(50, 165, 200, 40);
        registerButton.addActionListener(this);
        add(registerButton);

        playAsGuestButton = new JButton("Play as guest");
        playAsGuestButton.setBounds(50, 215, 200, 40);
        playAsGuestButton.addActionListener(this);
        add(playAsGuestButton);

        musicButton = new JButton("Play music");
        musicButton.setBounds(50, 250, 150, 35);
        musicButton.addActionListener(this);
        add(musicButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            DataBase.getPlayerDataBase().loadScoreBoard();

            for (Player p : DataBase.getPlayerDataBase().getPlayers()) {
                System.out.println(p.getLogin() + " " + p.getPassword());
                   if(p.getLogin().equals(loginField.getText()) && p.getPassword().equals(passwordField.getText())){
                        Window win = SwingUtilities.getWindowAncestor(this);
                        win.dispose();
                        FrameGame frameGame = new FrameGame(new PanelGame());


                }else {
                    JOptionPane.showMessageDialog(this, "Upppsss, coś posżło nie tak, spróbuj jeszcze raz");
                    loginField.setText("");
                    passwordField.setText("");
                }

            }


        }
        if (e.getSource() == registerButton) {

            Window win = SwingUtilities.getWindowAncestor(this);
            win.dispose();
            FrameRegister fR = new FrameRegister(new PanelRegister());
        }
        if (e.getSource() == playAsGuestButton) {

            Window win = SwingUtilities.getWindowAncestor(this);
            win.dispose();
            FrameGame frameGame = new FrameGame(new PanelGame());

        }

        if (e.getSource() == musicButton) {
            muzyka.playSound();

        }
        if (showPasswordButton.isSelected()) {
            passwordField.setEchoChar((char) 0);

        } else {
            passwordField.setEchoChar('*');
        }
    }

    public boolean loginVeryfication(String loginGiven, String loginRequired) {
        boolean isCorrect = false;

        if (loginGiven.equals(loginRequired)) {
            isCorrect = true;
        } else {
            JOptionPane.showMessageDialog(this, "NIeprawidłowy login");
        }
        return isCorrect;

    }

    public boolean passwordVeryfication(String passwordGiven,String passwordRequired) {
        boolean isCorrect = false;

        if(passwordGiven.equals(passwordRequired)){
            isCorrect = true;
        }else
            JOptionPane.showMessageDialog(this,"Nieprawidłowe hasło");
        return isCorrect;
    }


}


