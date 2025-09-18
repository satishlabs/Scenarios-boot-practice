package com.satishlabs.taxi.service;

import java.util.List;

import com.satishlabs.taxi.model.TaxiBooking;

public interface TaxiBookingService {
	TaxiBooking creatingBooking(TaxiBooking booking);
	List<TaxiBooking> getAllBookings();
	TaxiBooking getBookingById(Long id);
	TaxiBooking confirmedBooking(Long id);
	TaxiBooking cancelBooking(Long id);
	TaxiBooking completedBooking(Long id);
}
