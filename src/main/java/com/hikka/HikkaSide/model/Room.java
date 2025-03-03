package com.hikka.HikkaSide.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Data // Lombok annotation to auto-generate getters, setters, and toString
@Entity // Marks this class as a JPA entity (maps to a database table)
@AllArgsConstructor // Generates a constructor with all fields
public class Room {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID
    private Long id;

    private String roomType; // Type of the room (Single, Double, Suite, etc.)
    private BigDecimal roomPrice; // Price of the room
    private boolean isBooked = false; // Whether the room is currently booked

    @Lob // Stores large binary objects (photo of the room)
    private Blob photo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // One room can have multiple bookings
    private List<BookedRoom> bookings;

    // Default constructor initializes the bookings list
    public Room() {
        this.bookings = new ArrayList<>();
    }

    // Method to add a new booking to the room
    public void addBooking(BookedRoom booking){
        if (bookings == null) {
            bookings = new ArrayList<>();
        }

        // Add booking to the list and set the reference back to the room
        bookings.add(booking);
        booking.setRoom(this);

        // Mark the room as booked
        isBooked = true;

        // Generate a 10-digit booking confirmation code
        String bookingCode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(bookingCode);
    }
}
