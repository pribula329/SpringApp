package com.example.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {

    @Id
    private Integer id;
    private String name;
    private Integer yearsWorked;
    private Double fee;
    private String position;
    private String rating;
    private Date time;

    public User(Integer id, String name, Integer yearsWorked, Double fee, String position, String rating, Date time) {
        this.id = id;
        this.name = name;
        this.yearsWorked = yearsWorked;
        this.fee = fee;
        this.position = position;
        this.rating = rating;
        this.time = time;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearsWorked() {
        return yearsWorked;
    }

    public void setYearsWorked(Integer dept) {
        this.yearsWorked = dept;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double salary) {
        this.fee = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearsWorked='" + yearsWorked + '\'' +
                ", fee=" + fee +
                ", position='" + position + '\'' +
                ", rating='" + rating + '\'' +
                ", time=" + time +
                '}';
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
