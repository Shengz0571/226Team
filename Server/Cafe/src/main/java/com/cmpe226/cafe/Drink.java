package com.cmpe226.cafe;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drink {

//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")

@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long drink_id;
    private String ice_level;
    private String sugar_level;
    private double price;
    private String emp_id;
    private String tea_name;

//constructors
    public Drink(){}

    public Drink(long drink_id, String ice_level, String sugar, double price, String emp_id, String tea_name){
        this.drink_id = drink_id;
        this.ice_level = ice_level;
        this.sugar_level = sugar;
        this.price = price;
        this.emp_id = emp_id;
        this.tea_name = tea_name;
    }
//getters
    public double getPrice() {
        return price;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public String getIce_level() {
        return ice_level;
    }

    public long getDrink_id() {
        return drink_id;
    }

    public String getSugar() {
        return sugar_level;
    }

    public String getTea_name() {
        return tea_name;
    }
//print method
    @Override
    public String toString() {
        return getDrink_id() +" " + getTea_name() +" " + getSugar() +" " + getIce_level()+" " + getEmp_id();
    }
//setters

    public void setDrink_id(long drink_id){
        this.drink_id = drink_id;
    }
    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public void setIce_level(String ice_level) {
        this.ice_level = ice_level;
    }

    public void setSugar_level(String sugar) {
        this.sugar_level = sugar;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
