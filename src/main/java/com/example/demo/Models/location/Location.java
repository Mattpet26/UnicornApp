package com.example.demo.Models.location;

import com.example.demo.Models.unicorn.Unicorn;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long Id;

    public String Name;

    @OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE)
    public Set<Unicorn> unicorns = new HashSet<Unicorn>();

    public Location() {
    }

    public Location(String name, Set<Unicorn> unicorns) {
        Name = name;
        this.unicorns = unicorns;
    }

    public Location(String name) {
        Name = name;
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

    public Set<Unicorn> getUnicorns() {
        return unicorns;
    }

    public void setUnicorns(Set<Unicorn> unicorns) {
        this.unicorns = unicorns;
    }
}
