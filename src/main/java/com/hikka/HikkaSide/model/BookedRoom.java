package com.hikka.HikkaSide.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data // Lombok annotation to generate getters, setters, and toString
@Entity // Marks this class as a JPA entity (maps to a database table)
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor  // Generates a no-argument constructor
public class BookedRoom {

    @Id // Primary key for the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID
    private Long bookingId;

    @Column(name = "check_in") // Maps column name to 'check_in' in the database
    private LocalDate checkInDate;

    @Column(name = "check_out") // Maps column name to 'check_out' in the database
    private LocalDate checkOutDate;

    @Column(name = "guest_FullName") // Stores the full name of the guest
    private String guestFullName;

    @Column(name = "guest_Email") // Stores the email of the guest
    private String guestEmail;

    @Column(name = "adults") // Stores the number of adults
    private int noOfAdults;

    @Column(name="children") // Stores the number of children
    private int noOfChildren;

    @Column(name = "total_Guest") // Stores the total number of guests
    private int totalNoOfGuest;

    @Column(name = "confirmation_code") // Stores the booking confirmation code
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY) // Many booked rooms can belong to one room
    @JoinColumn(name ="room_id") // Foreign key reference to the 'room' table
    private Room room;

    // Method to calculate total guests dynamically
    public void calculateTotalNumberOfGuest(){
        this.totalNoOfGuest = this.noOfAdults + this.noOfChildren;
    }

    // Automatically update the total number of guests when setting adults or children
    public void setNoOfAdults(int noOfAdults) {
        this.noOfAdults = noOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
        calculateTotalNumberOfGuest();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
