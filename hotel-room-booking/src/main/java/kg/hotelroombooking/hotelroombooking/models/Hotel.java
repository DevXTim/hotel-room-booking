package kg.hotelroombooking.hotelroombooking.models;

import kg.hotelroombooking.hotelroombooking.models.enums.RoomType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Hotel {
    private int roomId;
    private int roomsCount;
    private int floor;
    private RoomType roomType;
    private double price;

    public Hotel(int roomId, int roomsCount, int floor, RoomType roomType) {
        this.roomId = roomId;
        this.roomsCount = roomsCount;
        this.floor = floor;
        this.roomType = roomType;
        this.price = roomType.getPrice();
    }
}
