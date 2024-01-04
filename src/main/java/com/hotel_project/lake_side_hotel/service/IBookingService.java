package com.hotel_project.lake_side_hotel.service;

import com.hotel_project.lake_side_hotel.model.BookedRoom;

import java.util.List;


public interface IBookingService {
      List<BookedRoom> getAllBookingsByRoomId(Long roomId);

      List<BookedRoom> getAllBookings();

      BookedRoom findByBookingConfirmationCode(String confirmationCode);

      String saveBooking(Long roomId, BookedRoom bookingRequest);

      void cancelBooking(Long bookingId);
}
