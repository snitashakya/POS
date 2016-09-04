/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.PointOfSale.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
import com.leapfrog.PointOfSale.entity.Users;
import com.leapfrog.PointOfSale.dao.UsersDAO;
import com.leapfrog.PointOfSale.dao.UsersDAOImpl;

/**
 *
 * @author ASUS
 */
public class RegisterUi extends JFrame {

    private JLabel lbl_firstname, lbl_lastname, lbl_password, lbl_email, lblconpassword, lbl_contactno;
    private JTextField txt_firstname, txt_lastname, txt_email, txt_contactno;
    private JTextField txt_password, txt_conpassword;
    private JButton btn_clear, btn_register;
    private String gender;
    private boolean invalid;

    //private JRadioButton rbtn_gender;
    public RegisterUi() {

        setTitle("Register");
        setSize(250, 500);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);

    }

    private void initComponents() {

        lbl_firstname = new JLabel("First Name :");
        lbl_lastname = new JLabel("Last Name :");
        lbl_email = new JLabel("Email :");
        lbl_password = new JLabel("Password:");
        lblconpassword = new JLabel(" Confirm Password :");
        lbl_contactno = new JLabel(" Contact No. :");
        txt_password = new JTextField(20);
        txt_firstname = new JTextField(20);
        txt_lastname = new JTextField(20);
        txt_email = new JTextField(20);
        txt_conpassword = new JTextField(20);
        txt_contactno = new JTextField(20);

        btn_clear = new JButton("Clear");
        btn_register = new JButton("Register");
        btn_register.addActionListener(new RegisterButtonListener());
        btn_clear.addActionListener(new ClearButtonListener());

        add(lbl_firstname);
        add(txt_firstname);
        add(lbl_lastname);
        add(txt_lastname);
        add(lbl_email);
        add(txt_email);
        add(lbl_password);
        add(txt_password);
        add(lblconpassword);
        add(txt_conpassword);
        add(lbl_contactno);
        add(txt_contactno);

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");
        ButtonGroup bG = new ButtonGroup();
        bG.add(male);
        bG.add(female);

        this.add(male);
        this.add(female);
        this.add(other);
        male.setSelected(true);
        if (male.isSelected()) {
            gender = "M";
        } else if (female.isSelected()) {
            gender = "F";
        } else if (other.isSelected()) {
            gender = "O";
        }
        this.setVisible(true);

        add(btn_register);
        add(btn_clear);

    }

    private class RegisterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale", "root", null);
                UsersDAO udao = new UsersDAOImpl();
                /*  if (u.getUsername().equals(txt_username.getText())) {
                 JOptionPane.showMessageDialog(null, " Username already Exist");*/
                if (txt_password.getText().equals(txt_conpassword.getText())) {
                    udao.Insert(new Users(0, txt_firstname.getText(), txt_lastname.getText(), txt_firstname.getText(), txt_email.getText(), txt_password.getText(), gender, txt_contactno.getText(), false));
                    JOptionPane.showMessageDialog(null, " Successfully Inserted");
                } else {
                    JOptionPane.showMessageDialog(null, "Password don't Matched");
                    txt_conpassword.setFocusable(true);
                }
                try {
                    int val = Integer.parseInt(txt_contactno.getText());
                    Boolean invalid = false;
                } catch (NumberFormatException n) {
                    // System.out.println("Invalid");
                    invalid = true;
                }

            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex.getMessage());

            }

        }
    }
        private class ClearButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                txt_firstname.setText("");
                txt_lastname.setText("");
                txt_password.setText("");
                txt_email.setText("");
                txt_conpassword.setText("");
                txt_contactno.setText("");

            }

        }
}
    
    

    
