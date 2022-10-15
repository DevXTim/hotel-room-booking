package kg.hotelroombooking.hotelroombooking.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomType {
    STANDARD(150),
    COMFORT(270),
    LUX(550),
    PRESIDENT(1300);

    private double price;
}
