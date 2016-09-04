/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.PointOfSale.ui;

import com.leapfrog.PointOfSale.dao.UsersDAO;
import com.leapfrog.PointOfSale.dao.UsersDAOImpl;
import com.leapfrog.PointOfSale.entity.Users;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class LoginUI extends JFrame {

    private JLabel lbl_username, lbl_password;
    private JTextField txt_username, txtpassword;
    private JButton btn_login, btn_register;

    public LoginUI() {

        setTitle("Login");
        setSize(250, 175);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        setVisible(true);

    }

    private void initComponents() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        lbl_username = new JLabel("Username :");
        txt_username = new JTextField(20);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        lbl_password = new JLabel("Password :");
        txtpassword = new JTextField(20);

        btn_login = new JButton("Login");
        btn_register = new JButton("Register");
        btn_register.addActionListener(new RegisterButtonListener());
        btn_login.addActionListener(new LoginButtonListener());
        add(lbl_username);
        add(txt_username);

        add(lbl_password);
        add(txtpassword);

        add(btn_login);
        add(btn_register);

    }

    private class RegisterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            RegisterUi regui = new RegisterUi();
        }

    }

    private class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale", "root", null);
                UsersDAO udao = new UsersDAOImpl();
                for (Users u : udao.getall()) {

                    if (!(u.getUsername().equals(txt_username.getText())) || (u.getPassword().equals(txtpassword.getText()))) {
                        POSUi pos = new POSUi();
                    } else {
                        JOptionPane.showMessageDialog(null, " Username or password incorrect. Please try again.");
                    }

                }
            } catch (ClassNotFoundException | SQLException ce) {
                System.out.println(ce.getMessage());

            }

        }
    }

}

