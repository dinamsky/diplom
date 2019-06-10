package com.restik.mydiplom.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Restaurant {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String name;
    private String adress;
    private String phoneNumber;
    private int tablesQty;

    @OneToMany(mappedBy = "restaurant",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Tables> tablesList = new ArrayList<>();

    public int getTablesQty() {
        return tablesQty;
    }

    public void setTablesQty(int tablesQty) {
        this.tablesQty = tablesQty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Tables> getTablesList() {
        return tablesList;
    }

    public void setTablesList(List<Tables> tablesList) {
        this.tablesList = tablesList;
    }



}
