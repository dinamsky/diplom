package com.restik.mydiplom.dao;

import com.restik.mydiplom.entity.Person;
import com.restik.mydiplom.entity.Visitor;
import com.restik.mydiplom.exception.ProjException;
import com.restik.mydiplom.repositories.PersonRep;
import com.restik.mydiplom.repositories.VisitorRep;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class VisitorDAO {
    @Autowired
    VisitorRep visitorRep;
    @Autowired
    PersonRep personRep;

    public VisitorDAO() {
    }

    public Visitor create(String firstName, String lastName, String username, String password, String roleType)
    {
        if(personRep.findByUsernameAndAndPassword(username, password) == null)  {

            System.out.println("User already exists");
            return null;

        }
        else{

                Visitor user=new Visitor();

                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setUsername(username);
                user.setPassword(password);
                user.setRoleType(roleType);

                personRep.save(user);


                return user;


    }}

    public void delete(Visitor visitor){
     personRep.delete(visitor);

    }

    public boolean findUser(String username){

        if(personRep.findByUsername(username)!=null){
            return true;
        } else{
            return false;
        }
    }
}
