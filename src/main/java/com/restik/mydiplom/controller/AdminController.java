package com.restik.mydiplom.controller;

import com.restik.mydiplom.dao.AdminOfRestaurantDAO;
import com.restik.mydiplom.entity.AdminOfRestaurant;
import com.restik.mydiplom.exception.ProjException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("registerAdmin.htm")
public class AdminController {
@Autowired
AdminOfRestaurantDAO restDAO;

    @RequestMapping(method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("regAdmin") AdminOfRestaurant restAdmin) throws Exception {

            restDAO.create(restAdmin.getFirstName(),restAdmin.getLastName(),restAdmin.getUsername(),restAdmin.getPassword(),restAdmin.getRoleType());

        return "home";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initializeForm(@ModelAttribute("regAdmin") AdminOfRestaurant restAdmin) {
        return "home";
    }
}
