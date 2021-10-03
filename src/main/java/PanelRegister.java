import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelRegister extends JPanel implements ActionListener {

    private final int width = 400, height = 600;

    private final JLabel loginLabel, firstNameLabel, lastNameLabel, passwordLabel, repeatPasswordLabel, nickLabel;

    private final JTextField loginField, fNField, lNField, nickField;
    private final JPasswordField passwordField, rPasswordField;

    private final JRadioButton showPasswordButton;

    private final JButton registerButton, backButton;

    BufferedImage tloWelcome;

    public PanelRegister() {
        try {
            tloWelcome = ImageIO.read(new File("tloWelcome.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);

        loginLabel = new JLabel("ID: ");
        loginLabel.setBounds(20, 20, 100, 30);
        add(loginLabel);

        firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setBounds(20, 70, 100, 30);
        add(firstNameLabel);

        lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setBounds(20, 120, 100, 30);
        add(lastNameLabel);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(20, 170, 100, 30);
        add(passwordLabel);


        repeatPasswordLabel = new JLabel("Repeat Password: ");
        repeatPasswordLabel.setBounds(20, 230, 100, 30);
        add(repeatPasswordLabel);

        nickLabel = new JLabel("Nick:");
        nickLabel.setBounds(20, 280, 100, 30);
        add(nickLabel);

        loginField = new JTextField();
        loginField.setBounds(150, 20, 100, 30);
        add(loginField);

        fNField = new JTextField();
        fNField.setBounds(150, 70, 100, 30);
        add(fNField);

        lNField = new JTextField();
        lNField.setBounds(150, 120, 100, 30);
        add(lNField);

        String passwordInfo = "- musi mieć 8 - 15 znaków \n- 1 wielką literę\n- 1 cyfrę\n- 1 znak specjalny";
        JTextPane passwordInfoArea = new JTextPane();
        passwordInfoArea.setText(passwordInfo);
        passwordInfoArea.setBounds(200, 200, 180, 80);
        passwordInfoArea.setBackground(Color.CYAN);
        passwordInfoArea.setVisible(false);
        add(passwordInfoArea);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 170, 100, 30);
        passwordField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                passwordInfoArea.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                passwordInfoArea.setVisible(false);
            }
        });
        add(passwordField);


        rPasswordField = new JPasswordField();
        rPasswordField.setBounds(150, 230, 100, 30);
        add(rPasswordField);

        nickField = new JTextField();
        nickField.setBounds(150, 280, 100, 30);
        add(nickField);

        showPasswordButton = new JRadioButton("Show Password");
        showPasswordButton.setBounds(150, 205, 150, 15);
        showPasswordButton.addActionListener(this);
        add(showPasswordButton);

        registerButton = new JButton("REGISTER");
        registerButton.setBounds(200, 350, 150, 40);
        registerButton.addActionListener(this);
        add(registerButton);

        backButton = new JButton("BACK");
        backButton.setBounds(50, 350, 150, 40);
        backButton.addActionListener(this);
        add(backButton);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tloWelcome,0,0,getWidth(),getHeight(),null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerButton) {
            if (isPasswordCorrect(passwordField.getText(), passwordField.getText()))
                DataBase.getPlayerDataBase().addPlayer(new Player(fNField.getText(), lNField.getText(), loginField.getText(), passwordField.getText(), nickField.getText(), 0, 0));

        }

        if (e.getSource() == backButton) {
            Window win = SwingUtilities.getWindowAncestor(this);
            win.dispose();

            FrameWelcome fW = new FrameWelcome(new PanelWelcome());
        }

        if (showPasswordButton.isSelected() == true) {
            passwordField.setEchoChar((char) 0);
            rPasswordField.setEchoChar((char) 0);

        } else {
            passwordField.setEchoChar('*');
            rPasswordField.setEchoChar('*');
        }
    }


    //łopatologiczne sprawdzanie znaków w haśle

    private boolean isPasswordAccepted(String password) {

        int specialCharAmount = 0, digitAmount = 0, capitalAmount = 0;
        for (int i = 0; i < password.length(); i++) {
            if ((password.charAt(i) >= 33 && password.charAt(i) <= 47)
                    || (password.charAt(i) >= 58 && password.charAt(i) <= 64)
                    || (password.charAt(i) >= 91 && password.charAt(i) <= 96)
                    || (password.charAt(i) >= 123 && password.charAt(i) <= 125)) specialCharAmount++;

            if (password.charAt(i) >= 48 && (password.charAt(i) <= 57)) digitAmount++;

            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) capitalAmount++;


        }

        return specialCharAmount >= 1 && digitAmount >= 1 && capitalAmount >= 1;
    }

    private boolean isPasswordLengthAccepted(String password) {
        return password.length() >= 8 && password.length() <= 15;
    }

    private boolean isPasswoordRepeatedAccepted(String password, String repeatedPassword) {
        return password.equals(repeatedPassword);
    }

    //Sprawdzanie poszczególnych aspektów hasła

    private boolean isPasswordCorrect(String password, String repeatedPassword) {

        if (!isPasswordAccepted(password))
            JOptionPane.showMessageDialog(this, "Hasło nieprawidłowe!");
        else if (!isPasswoordRepeatedAccepted(password, repeatedPassword))
            JOptionPane.showMessageDialog(this, "Hasła nie są identyczne");
        else if (!isPasswordLengthAccepted(password))
            JOptionPane.showMessageDialog(this, "Podane hasło jest za krótkie");


        return isPasswordAccepted(password) && isPasswordLengthAccepted(password) && isPasswoordRepeatedAccepted(password, repeatedPassword);
    }

}


