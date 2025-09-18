package com.satishlabs.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.taxi.model.TaxiBooking;

public interface TaxiBookingRepository extends JpaRepository<TaxiBooking, Long>{

}
