package com.hotel_project.lake_side_hotel.controller;

import com.hotel_project.lake_side_hotel.exception.InvalidBookingRequestException;
import com.hotel_project.lake_side_hotel.exception.ResourceNotFoundException;
import com.hotel_project.lake_side_hotel.model.BookedRoom;
import com.hotel_project.lake_side_hotel.response.BookingResponse;
import com.hotel_project.lake_side_hotel.service.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bookings")
public class BookedRoomController {
    private final IBookingService bookingService;

    @GetMapping("/all-bookings")
    public ResponseEntity<List<BookingResponse>> getAllBookings(){
        List<BookedRoom> bookings = bookingService.getAllBookings();
        List<BookingResponse> bookingResponses = new ArrayList<>();
        for (BookedRoom booking : bookings){
            BookingResponse bookingResponse = getBookingResponse(booking);
            bookingResponses.add(bookingResponse);
        }
        return ResponseEntity.ok(bookingResponses);
    }

    @GetMapping("/confirmation/{confirmationCode")
    public ResponseEntity<?> getBookingByConfirmationCode(@PathVariable String confirmationCode){
        try {
            BookedRoom booking = bookingService.findByBookingConfirmationCode(confirmationCode);
            BookingResponse bookingResponse = getBookingResponse(booking);
            return ResponseEntity.ok(bookingResponse);
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/room/{roomId}/booking")
    public ResponseEntity<?> saveBooking(@PathVariable Long roomId,
                                         @RequestBody BookedRoom bookingRequest){
        try{
            String confirmationCode = bookingService.saveBooking(roomId, bookingRequest);
            return ResponseEntity.ok(
                    "Room booked successfully ! Your booking confirmation code is "
                            + confirmationCode);
        }catch (InvalidBookingRequestException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
