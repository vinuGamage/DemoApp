package com.spring.dao;

import com.spring.model.User;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {

    public String generateUserId() throws SQLException, ClassNotFoundException;
    public boolean registerUser(User user) throws ClassNotFoundException, SQLException;
    public String validateLogin(String username);
    public boolean hashingPaswordandValidating(String pass, String username) throws NoSuchAlgorithmException;
    public String encryptThisString(String input);
    public boolean checkExistence(String username);
    public ArrayList<User> retrieveUsers();
    public boolean updateUser(String firstName,String lastName,String username);
    public boolean deleteUser(String username);
}
