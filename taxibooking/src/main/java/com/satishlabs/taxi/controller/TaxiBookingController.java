package com.satishlabs.taxi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.satishlabs.taxi.TaxibookingApplication;
import com.satishlabs.taxi.model.TaxiBooking;
import com.satishlabs.taxi.service.TaxiBookingService;

@RestController
@RequestMapping("/api/bookings")
public class TaxiBookingController {

    private final TaxibookingApplication taxibookingApplication;

	private final TaxiBookingService taxiBookingService;
	
	public TaxiBookingController(TaxiBookingService taxiBookingService, TaxibookingApplication taxibookingApplication) {
		this.taxiBookingService = taxiBookingService;
		this.taxibookingApplication = taxibookingApplication;
	}
	
	@PostMapping
	public ResponseEntity<TaxiBooking> createBooking(@RequestBody TaxiBooking taxiBooking) {
		return ResponseEntity.ok(taxiBookingService.creatingBooking(taxiBooking));
	}
	
	@GetMapping
	public ResponseEntity<List<TaxiBooking>> getAllBookings(){
		return ResponseEntity.ok(taxiBookingService.getAllBookings());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaxiBooking> getBookingById(@PathVariable Long id){
		return ResponseEntity.ok(taxiBookingService.getBookingById(id));
	}
	
	@PutMapping("/{id}/confirm")
	public ResponseEntity<TaxiBooking> confirmBooking(@PathVariable Long id){
		return ResponseEntity.ok(taxiBookingService.confirmedBooking(id));
	}
	
	@PutMapping("/{id}/cancel")
	public ResponseEntity<TaxiBooking> cancelBooking(@PathVariable Long id){
		return ResponseEntity.ok(taxiBookingService.cancelBooking(id));
	}
	
	@PutMapping("/{id}/complete")
	public ResponseEntity<TaxiBooking> completeBooking(@PathVariable Long id){
		return ResponseEntity.ok(taxiBookingService.completedBooking(id));
	}
	
	
}
