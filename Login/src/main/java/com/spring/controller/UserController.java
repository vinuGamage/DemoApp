package com.spring.controller;

import com.spring.dao.UserDAO;
import com.spring.daoImp.UserDAOImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;

@Controller
public class UserController {

    @RequestMapping("/updateUser")
    public String updateUserdirect(@RequestParam("userId") String userId, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("username") String username, Model model){
        model.addAttribute("userId",userId);
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("username",username);
        return "UpdateUser";
    }

    @RequestMapping("/processUpdate")
    public String updateProcess( @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("username") String username){
        UserDAO userDao = new UserDAOImp();
        System.out.println("UserName11 : " + username);
        System.out.println("FirstName11 : " + firstName);
        System.out.println("lastName11 : " + lastName);
        if (userDao.updateUser(firstName,lastName,username)){
            JOptionPane pane = new JOptionPane("Successfully Updated ", JOptionPane.OK_OPTION);
            JDialog dialog = pane.createDialog("Status");
            dialog.setAlwaysOnTop(true);
            dialog.show();
            return "AllUsers";
        }else{
            JOptionPane pane = new JOptionPane("Successfully not Updated ", JOptionPane.OK_OPTION);
            JDialog dialog = pane.createDialog("Status");
            dialog.setAlwaysOnTop(true);
            dialog.show();
            return "AllUsers";
        }

    }

    @RequestMapping("/deleteUser")
    public String deleteProcess(@RequestParam("username") String username){
        UserDAO userDAO = new UserDAOImp();
        if (userDAO.deleteUser(username)){
            JOptionPane pane = new JOptionPane("Successfully deleted ", JOptionPane.OK_OPTION);
            JDialog dialog = pane.createDialog("Status");
            dialog.setAlwaysOnTop(true);
            dialog.show();
            return "AllUsers";
        }else{
            JOptionPane pane = new JOptionPane("Successfully not deleted ", JOptionPane.OK_OPTION);
            JDialog dialog = pane.createDialog("Status");
            dialog.setAlwaysOnTop(true);
            dialog.show();
            return "AllUsers";
        }

    }

}
