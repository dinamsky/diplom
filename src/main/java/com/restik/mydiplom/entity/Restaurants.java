package com.restik.mydiplom.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Restaurants {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String name;
    private String adress;
    private String phoneNumber;

    @OneToMany(mappedBy = "restaurant")
    private List<Tables> tablesList = new ArrayList<>();

}
