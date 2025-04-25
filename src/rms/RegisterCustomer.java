package rms;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterCustomer extends JFrame {
    public RegisterCustomer() {
        setTitle("Register Customer");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField nameField = new JTextField(15);
        JTextField phoneField = new JTextField(15);
        JButton registerButton = new JButton("Register");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:")); panel.add(nameField);
        panel.add(new JLabel("Phone:")); panel.add(phoneField);
        panel.add(registerButton);
        add(panel);

        registerButton.addActionListener(e -> {
            try (Connection con = DBConnection.getConnection()) {
                String sql = "INSERT INTO customers (name, phone) VALUES (?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nameField.getText());
                stmt.setString(2, phoneField.getText());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Customer Registered!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }
}
