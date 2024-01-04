package com.hotel_project.lake_side_hotel.service;

import com.hotel_project.lake_side_hotel.model.BookedRoom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBookingServiceImpl implements IBookingService {
    @Override
    public List<BookedRoom> getAllBookingsByRoomId(Long roomId) {
        return null;
    }
}
