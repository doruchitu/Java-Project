package Clase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFrame extends JFrame {

    private JPanel panel;
    private JLabel usernameLabel;
    private JTextField usernameField;

    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);


        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 50, 80, 30);
        panel.add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 200, 30);
        panel.add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 150, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (UserManager.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);

                    new DashboardFrame(LoginFrame.this).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(200, 150, 150, 30);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (!username.isEmpty() && !password.isEmpty()) {
                    UserManager.writeUser(new User(username, password));
                    JOptionPane.showMessageDialog(LoginFrame.this, "User registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Please enter a valid username and password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(registerButton);

        add(panel);
    }
}
