package com.example.demo.Models.unicorn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnicornRepo extends JpaRepository<Unicorn, Long> {
    public Unicorn findByName(String UnicornName);
}
