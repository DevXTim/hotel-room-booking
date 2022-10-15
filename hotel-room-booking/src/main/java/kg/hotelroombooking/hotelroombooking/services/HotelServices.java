package kg.hotelroombooking.hotelroombooking.services;

import kg.hotelroombooking.hotelroombooking.models.CalculateRequest;
import kg.hotelroombooking.hotelroombooking.models.CalculateResponse;
import kg.hotelroombooking.hotelroombooking.models.Hotel;

import java.util.List;

public interface HotelServices {
    List<Hotel> getAllRooms(int page, int elements, int roomId);

    CalculateResponse calculate(CalculateRequest calculateRequest);

    Hotel getRoomById(int roomId);

    Hotel createRoom(Hotel hotel);
}
