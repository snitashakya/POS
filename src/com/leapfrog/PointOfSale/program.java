/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.PointOfSale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import com.leapfrog.PointOfSale.ui.LoginUI;
import com.leapfrog.PointOfSale.ui.RegisterUi;



/**
 *
 * @author ASUS
 */
public class program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginUI  logui=new LoginUI();
       
        /*try {
            // TODO code application logic here
           //  System.out.println("abc");
            Class.forName("com.mysql.jdbc.Driver");
           
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/loan_manager", "root", null);
            Statement stmt=conn.createStatement();
            String sql="Insert into tbl_contacts(firstname,lastname,email,contact_no,gender,status)values('snita','shakya','snita@gmail.com','9999999999','F',0)";
            int result=stmt.executeUpdate(sql);
             
            System.out.println(result);
            conn.close();
            */
       /* } catch (ClassNotFoundException | SQLException ex) {
           System.out.println(ex.getMessage());
           // System.out.println("mmn");*/
       // }*/
    }
    
}
