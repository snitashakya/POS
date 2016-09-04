/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.PointOfSale.dao;

import com.leapfrog.PointOfSale.entity.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class UsersDAOImpl implements UsersDAO {

    @Override
    public int Insert(Users user) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale", "root", null);
        String sql = "Insert into tbl_users(firstname,lastname,username,email,password,gender,contact_no,Status)values(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getFirstname());
        stmt.setString(2, user.getLastname());
        stmt.setString(3, user.getUsername());
        stmt.setString(4, user.getEmail());
        stmt.setString(5, user.getPassword());
        stmt.setString(6, user.getGender());
        stmt.setString(7, user.getContactno());
        stmt.setBoolean(8, user.isStatus());
        int result = stmt.executeUpdate();
        /* if(stmt.executeUpdate()>0)
         {
         JOptionPane.showMessageDialog(null, "Inserted Successfully.");
         }*/

        conn.close();
        return result;

    }

    @Override
    public List<Users> getall() throws ClassNotFoundException, SQLException {
        List<Users> userlist = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale", "root", null);
        String sql = "Select * from tbl_users";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Users user = new Users();
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setGender(rs.getString("gender"));
            user.setContactno(rs.getString("contact_no"));
            user.setStatus(rs.getBoolean("status"));
            userlist.add(user);
        }
        conn.close();
        return userlist;
    }

    @Override
    public int Update(Users user) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Delete(Users user) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
