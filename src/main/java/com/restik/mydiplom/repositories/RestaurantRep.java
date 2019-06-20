package com.restik.mydiplom.repositories;

import com.restik.mydiplom.entity.AdminOfRestaurant;
import com.restik.mydiplom.entity.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRep extends CrudRepository<Restaurant,Integer> {
    Restaurant findByRestAdmin(AdminOfRestaurant restAdmin);
    Restaurant findByRestName(String restName);
    @Query(nativeQuery = true,value = "select * from Restaurant")
    Restaurant findAllby();
}
