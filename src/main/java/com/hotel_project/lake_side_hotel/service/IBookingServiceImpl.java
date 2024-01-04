package com.hotel_project.lake_side_hotel.service;

import com.hotel_project.lake_side_hotel.model.BookedRoom;
import com.hotel_project.lake_side_hotel.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IBookingServiceImpl implements IBookingService {

    private final BookingRepository bookingRepository;
    @Override
    public List<BookedRoom> getAllBookingsByRoomId(Long roomId) {
        return null;
    }

    @Override
    public List<BookedRoom> getAllBookings() {
        return null;
    }

    @Override
    public BookedRoom findByBookingConfirmationCode(String confirmationCode) {
        return null;
    }

    @Override
    public String saveBooking(Long roomId, BookedRoom bookingRequest) {
        return null;
    }

    @Override
    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
