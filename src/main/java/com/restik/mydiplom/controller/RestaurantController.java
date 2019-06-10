package com.restik.mydiplom.controller;

import com.restik.mydiplom.entity.Restaurant;
import com.restik.mydiplom.entity.Tables;
import com.restik.mydiplom.repositories.RestaurantRepository;
import com.restik.mydiplom.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private TableRepository tableRepository;

    @RequestMapping(value = "/restaurant/add", method = RequestMethod.GET)
    public String showForm (Model model){
        model.addAttribute("restaurant", new Restaurant());
        return "AddRestaurant";
    }

    @RequestMapping(value = "/restaurant/add", method = RequestMethod.POST)
    public String submitForm (@ModelAttribute Restaurant restaurant, Model model){
        restaurantRepository.save(restaurant);
        model.addAttribute("addInfo", restaurant.getName());

        return "AddRestaurant";
    }



}
