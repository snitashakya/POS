/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.PointOfSale.ui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class POSUi extends JFrame {

    private JButton btn_sale, btn_paid;

    public POSUi() {
        setTitle("POS");
        setSize(250, 250);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);

    }
    
    public void initComponents(){
        btn_sale = new JButton("Sale");
        btn_paid = new JButton("Paid");
        add(btn_sale);
        add(btn_paid);
    }
}


