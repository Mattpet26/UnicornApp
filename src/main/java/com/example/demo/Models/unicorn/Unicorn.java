package com.example.demo.Models.unicorn;

import com.example.demo.Models.location.Location;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
public class Unicorn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long Id;

    public String Name;
    public String Color;
    public String FavoriteFood;

    @ManyToOne
    public Location location;

    public Unicorn() {
    }

    public Unicorn(String name, String color, String favoriteFood, Location location) {
        Name = name;
        Color = color;
        FavoriteFood = favoriteFood;
        this.location = location;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getFavoriteFood() {
        return FavoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        FavoriteFood = favoriteFood;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
