package com.satishlabs.taxi.model;

import java.time.LocalDateTime;

import com.satishlabs.taxi.enums.BookingStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "taxibooking")
public class TaxiBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String pickupLocation;
	private LocalDateTime pickupTime;
	private String dropLocation;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus status;

    @Version
    private Long version;

    public TaxiBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public LocalDateTime getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(LocalDateTime pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    @Override
    public String toString() {
        return "TaxiBooking{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", pickupTime=" + pickupTime +
                ", dropLocation='" + dropLocation + '\'' +
                ", status=" + status +
                ", version=" + version +
                '}';
    }
}
