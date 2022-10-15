package kg.hotelroombooking.hotelroombooking.controllers;

import kg.hotelroombooking.hotelroombooking.models.CalculateRequest;
import kg.hotelroombooking.hotelroombooking.models.CalculateResponse;
import kg.hotelroombooking.hotelroombooking.models.Hotel;
import kg.hotelroombooking.hotelroombooking.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    @Autowired
    HotelServices hotelServices;

    @GetMapping("/list")
    public List<Hotel> listRooms(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int elements,
            @RequestParam(required = false, defaultValue = "-1") int roomId) {
        return hotelServices.getAllRooms(page, elements, roomId);
    }

    @GetMapping("/list/{id}")
    public Hotel getRoomById(@PathVariable int id) {
        return hotelServices.getRoomById(id);
    }

    @PostMapping("/calculate")
    public CalculateResponse calculatePrice(@RequestBody CalculateRequest calculateRequest) {
        return hotelServices.calculate(calculateRequest);
    }

    @PostMapping("/create")
    public Hotel createRoom(@RequestBody Hotel hotel) {
        return hotelServices.createRoom(hotel);
    }
}
