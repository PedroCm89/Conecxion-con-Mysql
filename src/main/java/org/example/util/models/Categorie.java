package org.example.util.models;

public class Categorie {


    public Categorie() {
    }

    public Categorie(Long id) {
        this.id = id;
    }

    private Long id;
    private String name;

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
}
