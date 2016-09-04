/*
 * To chang65e this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.PointOfSale.entity;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Users {
    private int user_id;
    private String firstname,lastname,gender,email,contactno,username,password;
    private Date added_date;
    private boolean status;
    
    public Users(){
       
    }

    public Users(int user_id, String firstname, String lastname, String username,String email,String password, String gender, String contactno,boolean status ) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.contactno = contactno;
        this.password=password;
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getUsername() {
        return username;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getContactno() {
        return contactno;
    }

 /*   public Date getAdded_date() {
        return added_date;
    }*/

    public boolean isStatus() {
        return status;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

 /*   public void setAdded_date(Date added_date) {
        this.added_date = added_date;
    }*/

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
