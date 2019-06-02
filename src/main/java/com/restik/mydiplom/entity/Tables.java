package com.restik.mydiplom.entity;

import org.hibernate.annotations.GenericGenerator;

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

    private String tableNum;

    private int visitorsVolume;

    @OneToOne(mappedBy = "table")
    private List<Reserve> reserveList = new ArrayList<>();





}
