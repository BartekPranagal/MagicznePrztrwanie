import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelRegister extends JPanel implements ActionListener {

    private final int width = 400,height = 600;

    private final JLabel idLabel,firstNameLabel,lastNameLabel, passwordLabel, repeatPasswordLabel,nickLabel;

    private final JTextField idField,fNField,lNField, nickField;
    private final JPasswordField passwordField,rPasswordField;

    private final JRadioButton showPasswordButton;

    private final JButton registerButton, backButton;



    public PanelRegister() {

        setLayout(null);

        idLabel = new JLabel("ID: ");
        idLabel.setBounds(20, 20, 100, 30);
        add(idLabel);

        firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setBounds(20, 70, 100, 30);
        add(firstNameLabel);

        lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setBounds(20, 120, 100, 30);
        add(lastNameLabel);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(20,  170, 100, 30);
        add(passwordLabel);

        repeatPasswordLabel = new JLabel("Reapet Password: ");
        repeatPasswordLabel.setBounds(20, 230, 100, 30);
        add(repeatPasswordLabel);

        nickLabel = new JLabel("Nick:");
        nickLabel.setBounds(20,  280, 100, 30);
        add(nickLabel);

        idField = new JTextField();
        idField.setBounds(150, 20, 100, 30);
        add(idField);

        fNField = new JTextField();
        fNField.setBounds(150, 70, 100, 30);
        add(fNField);

        lNField = new JTextField();
        lNField.setBounds(150, 120, 100, 30);
        add(lNField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 170, 100, 30);
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
    public Dimension getPreferredSize() {
        return new Dimension(width,height);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            JOptionPane.showMessageDialog(this, "Jeszcze nic tu nie ma ");

        }
        if(e.getSource() == backButton){
            Window win = SwingUtilities.getWindowAncestor(this);
            win.dispose();

            FrameWelcome  fW = new FrameWelcome(new PanelWelcome());
        }

        if (showPasswordButton.isSelected() == true) {
            passwordField.setEchoChar((char)0);
            rPasswordField.setEchoChar((char)0);

        } else {
            passwordField.setEchoChar('*');
            rPasswordField.setEchoChar('*');
        }
    }


}


