package com.satishlabs.taxi.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satishlabs.taxi.enums.BookingStatus;
import com.satishlabs.taxi.model.TaxiBooking;
import com.satishlabs.taxi.repository.TaxiBookingRepository;
import com.satishlabs.taxi.service.TaxiBookingService;

@Service
public class TaxiBookingServiceImpl implements TaxiBookingService{
	
	@Autowired
	private TaxiBookingRepository taxiBookingRepository;
	
	@Override
	public TaxiBooking creatingBooking(TaxiBooking booking) {
        if(booking.getId() != null){
            TaxiBooking taxiBooking = taxiBookingRepository.findById(booking.getId()).orElseThrow(() ->new RuntimeException("Booking not found"));
            taxiBooking.setPickupLocation(booking.getPickupLocation());
            taxiBooking.setPickupTime(booking.getPickupTime());
            taxiBooking.setDropLocation(booking.getDropLocation());
            taxiBooking.setUsername(booking.getUsername());
            taxiBooking.setStatus(booking.getStatus());

            return taxiBookingRepository.save(booking); //save updated entity
        }
		// TODO Auto-generated method stub
		return taxiBookingRepository.save(booking); //new booking
	}

	@Override
	public List<TaxiBooking> getAllBookings() {
		return taxiBookingRepository.findAll();
	}

	@Override
	public TaxiBooking getBookingById(Long id) {
		return taxiBookingRepository.findById(id).get();
	}

	@Override
	public TaxiBooking confirmedBooking(Long id) {
		TaxiBooking booking = taxiBookingRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Booking not found"));
		booking.setStatus(BookingStatus.CONFIRMED);
		return taxiBookingRepository.save(booking);
	}

	@Override
	public TaxiBooking cancelBooking(Long id) {
		TaxiBooking booking = taxiBookingRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Booking not found"));
		booking.setStatus(BookingStatus.CANCELLED);
		return taxiBookingRepository.save(booking);
	}

	@Override
	public TaxiBooking completedBooking(Long id) {
		TaxiBooking booking = taxiBookingRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Booking not found"));
		booking.setStatus(BookingStatus.COMPLETED);
		return taxiBookingRepository.save(booking);
	}

}
