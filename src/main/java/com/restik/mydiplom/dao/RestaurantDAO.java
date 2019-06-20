package com.restik.mydiplom.dao;

import com.restik.mydiplom.entity.AdminOfRestaurant;
import com.restik.mydiplom.entity.Restaurant;
import com.restik.mydiplom.exception.ProjException;
import com.restik.mydiplom.repositories.AdminRep;
import com.restik.mydiplom.repositories.RestaurantRep;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RestaurantDAO  {
    @Autowired
    RestaurantRep restaurantRep;
    @Autowired
    AdminRep adminRep;

    public RestaurantDAO(){
    }

    public Restaurant create(String restName, AdminOfRestaurant restAdmin){


            Restaurant rest = new Restaurant();
            rest.setRestName(restName);
            rest.setRestAdmin(restAdmin);
            restAdmin.setRestaurant(rest);
            adminRep.save(restAdmin);
            restaurantRep.save(rest);
            return rest;

    }

    public List<Restaurant> getAll(){
         return (List<Restaurant>) restaurantRep.findAll();
    }

    public Restaurant getMyRestaurant(AdminOfRestaurant restAdmin){

            return (Restaurant) restaurantRep.findByRestAdmin(restAdmin);

    }

    public Restaurant fetchMyRestaurant(String restName)
    {

            return  restaurantRep.findByRestName(restName);
        }
    }

