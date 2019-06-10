package com.restik.mydiplom.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Table
@Entity
public class Tables {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    //private String tableNum;
    private int visitorsVolume;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "tables")
    private List<Reserve> reserveList = new ArrayList<>();

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getVisitorsVolume() {
        return visitorsVolume;
    }

    public void setVisitorsVolume(int visitorsVolume) {
        this.visitorsVolume = visitorsVolume;
    }

    public List<Reserve> getReserveList() {
        return reserveList;
    }

    public void setReserveList(List<Reserve> reserveList) {
        this.reserveList = reserveList;
    }



}
