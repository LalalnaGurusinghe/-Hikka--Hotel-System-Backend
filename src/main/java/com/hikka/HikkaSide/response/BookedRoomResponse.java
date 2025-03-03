package com.hikka.HikkaSide.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data // Lombok annotation to auto-generate getters, setters, equals, and toString
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor  // Generates a no-argument constructor
public class BookedRoomResponse {
    private Long bookingId; // Unique identifier for the booking
    private LocalDate checkInDate; // Check-in date of the booking
    private LocalDate checkOutDate; // Check-out date of the booking
    private String guestFullName; // Full name of the guest
    private String guestEmail; // Email of the guest
    private int noOfAdults; // Number of adults in the booking
    private int noOfChildren; // Number of children in the booking
    private int totalNoOfGuest; // Total number of guests (adults + children)
    private String bookingConfirmationCode; // Unique confirmation code for the booking
    private RoomResponse room; // Associated room details

    // Constructor with essential booking details
    public BookedRoomResponse(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate, String bookingConfirmationCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
