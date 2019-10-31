package com.spring.daoImp;

import com.spring.dao.UserDAO;
import com.spring.model.User;
import com.spring.other.DBConnection;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class UserDAOImp implements UserDAO {

    public String generateUserId() throws SQLException, ClassNotFoundException {
        String query;
        query = "SELECT * FROM user";
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        String LastId = null;
        String NewId = null;
        ResultSet rst = pst.executeQuery();

        if (rst.next() == false) {
            return "U001";
        } else {
            rst = pst.executeQuery();
            while (rst.next()) {
                LastId = rst.getString(1);
            }
        }
        System.out.println("Last id " + LastId);
        int x = Integer.parseInt(LastId.substring(1));
        x = x + 1;
        DecimalFormat formatter = new DecimalFormat("000");
        String newX = formatter.format(x);
        NewId = LastId.substring(0, 1) + newX;
        System.out.println("NewId " + NewId);
        return NewId;

    }

    public boolean registerUser(User user) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO user (userId,firstName,lastName,username,password) VALUES (?,?,?,?,?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, user.getUserId());
        System.out.println("userId : " +  user.getUserId());
        ps.setString(2, user.getFirstName());
        System.out.println("fullname : " +  user.getFirstName());
        ps.setString(3, user.getLastName());
        System.out.println("lastname : " +  user.getLastName());
        ps.setString(4, user.getUsername());
        System.out.println("username : " +  user.getUsername());
        ps.setString(5, user.getPassword());
        System.out.println("password : " +  user.getPassword());
        System.out.println("inserted");
        ps.execute();

        return true;
    }

    //Further validating the hashed the password
    public  boolean hashingPaswordandValidating(String pass, String username) throws NoSuchAlgorithmException {

        String hash = validateLogin(username);

        if (pass.equals(hash)) {
            return true;
        } else {
            return false;
        }

    }

    //Hashing the password
    public  String encryptThisString(String input) {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkExistence(String username) {

        try {
            String query = "SELECT * FROM user WHERE username = ?";
           Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                return true;
            }
            System.out.println("in db");
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        }catch ( SQLException ex){
            ex.printStackTrace();
        }


        return false;
    }

    @Override
    public ArrayList<User> retrieveUsers() {
        try{
             String query = "SELECT * FROM user";
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rst = ps.executeQuery();

            ArrayList<User> users = new ArrayList<User>();
            // int count=0;
            while(rst.next()){
                User u1 = new User(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
                users.add(u1);
                // count++;
            }
           // System.out.println("paginated");
            return users ;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateUser(String firstName,String lastName,String username) {
        try {

            String query = "UPDATE user SET firstName=?,lastName=? WHERE username=?";
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, firstName);
            System.out.println("New firstName : " + firstName);
            ps.setString(2, lastName);
            System.out.println("New lastName : " + lastName);
            ps.setString(3, username);
            System.out.println("New uername : " + username);
            ps.execute();
            return true;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(String username) {
        try {
            String query = "DELETE FROM user WHERE username=? ";
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            System.out.println("PRE DELETE");
            ps.execute();
            return true;
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return false;


    }


    public String validateLogin(String username){
        try{
            String query1 = "SELECT * FROM user WHERE username = ?";

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query1);
            pst.setString(1, username);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                return rst.getString("password");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    return null;
    }
}
