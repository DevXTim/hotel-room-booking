package kg.hotelroombooking.hotelroombooking.services.impl;

import kg.hotelroombooking.hotelroombooking.models.CalculateRequest;
import kg.hotelroombooking.hotelroombooking.models.CalculateResponse;
import kg.hotelroombooking.hotelroombooking.models.Hotel;
import kg.hotelroombooking.hotelroombooking.models.enums.RoomType;
import kg.hotelroombooking.hotelroombooking.services.HotelServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServicesImpl implements HotelServices {

    private List<Hotel> hotelList = new ArrayList<>();

    {
        hotelList.add(new Hotel(1, 1, 1, RoomType.STANDARD));
        hotelList.add(new Hotel(2, 2, 2, RoomType.COMFORT));
        hotelList.add(new Hotel(3, 3, 3, RoomType.LUX));
    }

    @Override
    public List<Hotel> getAllRooms(int page, int elements, int roomId) {
        List<Hotel> finalList = hotelList;

        if (roomId != -1) {
            finalList =
                    finalList.stream()
                            .filter(hotel -> hotel.getRoomId() == roomId)
                            .collect(Collectors.toList());
        }
        finalList =
                finalList.stream()
                        .skip((long) (page - 1) * elements)
                        .limit(elements)
                        .collect(Collectors.toList());

        return finalList;
    }

    @Override
    public CalculateResponse calculate(CalculateRequest calculateRequest) {
        Hotel hotel = getRoomById(calculateRequest.getRoomId());
        double discount = getDiscount(calculateRequest.getDays());
        double totalAmount = calculateTotalAmount(hotel, calculateRequest.getDays(), discount);
        return new CalculateResponse(totalAmount, hotel, calculateRequest.getDays());
    }

    private double calculateTotalAmount(Hotel hotel, int days, double discount) {
        double totalPriceNoDiscount = hotel.getPrice() * days;

        return totalPriceNoDiscount - (totalPriceNoDiscount * discount) / 100;
    }

    private double getDiscount(int days) {
        double discount = 0;

        if (days >= 3 && days < 10) {
            discount = 5;
        } else if (days >= 10 && days < 20) {
            discount = 15;
        } else if (days >= 20) {
            discount = 30;
        }

        return discount;
    }

    @Override
    public Hotel getRoomById(int roomId) {
        try {
            return hotelList.stream()
                    .filter(hotelRoom -> hotelRoom.getRoomId() == roomId)
                    .collect(Collectors.toList())
                    .get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(String.format("No such id '%s' for booking a hotel room", roomId));
        }
    }

    @Override
    public Hotel createRoom(Hotel hotel) {
        hotelList.add(new Hotel(hotel.getRoomId(), hotel.getRoomsCount(), hotel.getFloor(), hotel.getRoomType()));
        return hotelList.get(hotelList.size() - 1);
    }
}
