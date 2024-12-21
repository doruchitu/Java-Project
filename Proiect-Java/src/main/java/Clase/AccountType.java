package Clase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountType extends JFrame{
    private Student studentType;
    private JPanel panel;
    public AccountType(Student studentType){
        this.studentType = studentType;
        setTitle("Account Type");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JButton backButton = new JButton("Student");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //studentType.setVisible(true);
            }
        });
        panel = new JPanel();
        panel.add(backButton);
        add(panel);
    }
}
