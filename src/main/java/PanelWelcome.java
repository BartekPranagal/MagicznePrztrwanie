import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelWelcome extends JPanel implements ActionListener {

    private final int width = 300, height = 300;

    private final JLabel loginLabel, passwordLabel;
    private final JTextField loginField;
    private final JPasswordField passwordField;
    private final JButton loginButton, registerButton, playAsGuestButton;
    private final JRadioButton showPasswordButton;

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

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            JOptionPane.showMessageDialog(this, "Jeszcze nic tu nie ma ");

        }
        if (e.getSource() == registerButton) {
            Window win = SwingUtilities.getWindowAncestor(this);
            win.dispose();

            FrameRegister fR = new FrameRegister(new PanelRegister());
        }
        if (e.getSource() == playAsGuestButton) {
            JOptionPane.showMessageDialog(this, "Jeszcze nic tu nie ma ");
            System.exit(0);

        }
        if (showPasswordButton.isSelected() == true) {
            passwordField.setEchoChar((char) 0);

        } else {
            passwordField.setEchoChar('*');
        }
    }


}


