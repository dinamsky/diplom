package com.restik.mydiplom.dao;

import com.restik.mydiplom.entity.AdminOfRestaurant;
import com.restik.mydiplom.entity.Person;
import com.restik.mydiplom.exception.ProjException;
import com.restik.mydiplom.repositories.AdminRep;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminOfRestaurantDAO {

    @Autowired
    AdminRep adminRep;

    public AdminOfRestaurantDAO() {

    }

    public AdminOfRestaurant create(String firstName, String lastName, String username, String password, String roleType) throws ProjException {

        if (adminRep.findByUsername(username)!=null) {
            System.out.println("Username already exists");
            return null;
        } else {


                AdminOfRestaurant restAd = new AdminOfRestaurant();
                restAd.setFirstName(firstName);
                restAd.setLastName(lastName);
                restAd.setUsername(username);
                restAd.setPassword(password);
                restAd.setRoleType(roleType);
                adminRep.save(restAd);


                return restAd;

    }}

    public void delete(AdminOfRestaurant restAd)
    {adminRep.delete(restAd);

    }


}
