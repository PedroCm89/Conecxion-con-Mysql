package org.example.util.models;

import java.util.Date;

public class Product {

    private Long id;
    private String name;
    private Integer price;

    private Date  DateRegistration;

    public Product() {
    }

    public Product(Long id, String name, Integer price, Date DateRegistration) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.DateRegistration = DateRegistration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDateRegistration() {
        return DateRegistration;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.DateRegistration = registrationDate;
    }

    @Override
    public String toString() {
        return  id +" | "+ name + " | " + price+" | " + DateRegistration ;
    }
}
