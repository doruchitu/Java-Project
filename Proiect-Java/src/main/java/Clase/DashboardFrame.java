package Clase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DashboardFrame extends JFrame {
    private LoginFrame loginFrame;
    private JPanel panel;
    public DashboardFrame(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                loginFrame.setVisible(true);
            }
        });
        panel = new JPanel();
        panel.add(backButton);
        add(panel);
    }
}
