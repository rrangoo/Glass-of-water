package com.glassofwater.gow.repository;

import com.glassofwater.gow.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepo extends JpaRepository<Trip, Long> {

    @Override
    void deleteById(Long id);
}
