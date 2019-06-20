package com.restik.mydiplom.dao;

import com.restik.mydiplom.entity.Person;
import com.restik.mydiplom.exception.ProjException;
import com.restik.mydiplom.repositories.PersonRep;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonDAO {
    @Autowired
    PersonRep personRep;
    public PersonDAO() {
    }

    public Person get(String username, String password){
        Person person = (Person)personRep.findByUsernameAndAndPassword(username,password);
        return person; }


    }




