/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.PointOfSale.dao;


import com.leapfrog.PointOfSale.entity.Users;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface UsersDAO {
    int Insert(Users user) throws ClassNotFoundException,SQLException;
    List<Users> getall() throws ClassNotFoundException,SQLException;
    int Update(Users user)  throws ClassNotFoundException,SQLException;
    int Delete (Users user) throws ClassNotFoundException,SQLException;
   
    
}
