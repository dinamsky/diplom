package com.restik.mydiplom.repositories;

import com.restik.mydiplom.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRep extends CrudRepository<Person,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM Person WHERE username='username' and password='password'")
    Person findByUsernameAndAndPassword(String username,String password);

    Person findByUsername(String username);



}
