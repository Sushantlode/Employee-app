package com.jetbrains.employeeapp;

public class employee {
    @Override
    public String toString() {
        return "{Id="+id+" Name="+name+" City="+city+"}";
    }

    private int id;
    private String name;
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
