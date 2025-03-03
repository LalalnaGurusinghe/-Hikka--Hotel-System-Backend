package com.hikka.HikkaSide.response;

import java.util.Base64;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data // Lombok annotation to generate getters, setters, equals, hashCode, and toString
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor  // Lombok annotation to generate a no-argument constructor
public class RoomResponse {
    private Long id;  // Unique identifier for the room
    private String roomType; // Type of the room (e.g., Single, Double, Suite)
    private BigDecimal roomPrice; // Price of the room
    private boolean isBooked = false; // Indicates if the room is booked
    private String photo; // Base64-encoded string of the room image
    private List<BookedRoomResponse> bookings; // List of room bookings

    // Constructor without the 'isBooked' and 'photo' fields
    public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    // Constructor that converts byte array photo into a Base64 string
    public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked, byte[] photoBytes, List<BookedRoomResponse> bookings) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        // If photoBytes is not null, convert it to Base64 string; otherwise, set to null
        this.photo = (photoBytes != null) ? Base64.getEncoder().encodeToString(photoBytes) : null;
        this.bookings = bookings;
    }
}
