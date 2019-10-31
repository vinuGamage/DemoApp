package com.spring.controller;

import com.spring.dao.UserDAO;
import com.spring.daoImp.UserDAOImp;
import com.spring.model.User;
import com.spring.other.PopMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Controller
public class RegisterController {

    //show register page
    @RequestMapping("/directToRegister")
    public String directToRegister(Model model){

        User userModel= new User();
        model.addAttribute("user",userModel);

        return "Register";
    }

    @RequestMapping("/processRegister")
    public String processRegistration(@ModelAttribute("user") User theUser) throws SQLException, ClassNotFoundException {
        UserDAO userDao = new UserDAOImp();

        if(!userDao.checkExistence(theUser.getUsername())){
            //encrypting the entered password
            String hashedPassword = userDao.encryptThisString(theUser.getPassword());
            User user = new User(userDao.generateUserId(),theUser.getFirstName(),theUser.getLastName(),theUser.getUsername(),hashedPassword);
                if (userDao.registerUser(user)){
                    //PopMessage.infoBox(theUser.getFirstName() + " " + theUser.getLastName() + " was successfully registered.","User registration Success Message");
                    JOptionPane pane = new JOptionPane( theUser.getFirstName() + " " + theUser.getLastName() + " was successfully registered. ", JOptionPane.OK_OPTION);
                    JDialog dialog = pane.createDialog("Status");
                    dialog.setAlwaysOnTop(true);
                    dialog.show();
                    return "Home";
                } else{
                    //PopMessage.infoBox(theUser.getFirstName() + " " + theUser.getLastName() + " was not successfully registered.","User registration Error Message");
                    JOptionPane pane = new JOptionPane( theUser.getFirstName() + " " + theUser.getLastName() + " was not successfully registered. ", JOptionPane.OK_OPTION);
                    JDialog dialog = pane.createDialog("Status");
                    dialog.setAlwaysOnTop(true);
                    dialog.show();
                    return "Register";
                }
        }else {
            PopMessage.infoBox(theUser.getUsername()  + " already exists.","Error Message");
            return "Register";
        }

    }

}
