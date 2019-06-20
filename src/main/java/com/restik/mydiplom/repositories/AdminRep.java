package com.restik.mydiplom.repositories;

import com.restik.mydiplom.entity.AdminOfRestaurant;
import org.springframework.data.repository.CrudRepository;

public interface AdminRep extends CrudRepository<AdminOfRestaurant,Integer> {
    AdminOfRestaurant findByUsername(String username);

}
