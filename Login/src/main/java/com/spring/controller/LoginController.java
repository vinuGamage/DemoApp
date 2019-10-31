package com.spring.controller;

import com.spring.dao.UserDAO;
import com.spring.daoImp.UserDAOImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam("username") String userName, @RequestParam("password") String password, Model model) throws NoSuchAlgorithmException {
        UserDAO userDao = new UserDAOImp();
        String hashedPassword = userDao.encryptThisString(password);
        if(userDao.hashingPaswordandValidating(hashedPassword,userName)){
           // PopMessage.infoBox("Successfully Logged In.","User Login Success Message");

            JOptionPane pane = new JOptionPane("Successfully logged In ", JOptionPane.OK_OPTION);
            JDialog dialog = pane.createDialog("Status");
            dialog.setAlwaysOnTop(true);
            dialog.show();
            return "AllUsers";
        }else{
            //PopMessage.infoBox("Successfully not Logged In.","User Login Error Message");
            JOptionPane pane = new JOptionPane("Successfully not Logged In ", JOptionPane.OK_OPTION);
            JDialog dialog = pane.createDialog("Status");
            dialog.setAlwaysOnTop(true);
            dialog.show();
            return "Home";
        }


    }

}
