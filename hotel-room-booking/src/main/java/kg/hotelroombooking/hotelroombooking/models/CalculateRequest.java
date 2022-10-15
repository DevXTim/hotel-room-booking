package kg.hotelroombooking.hotelroombooking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateRequest {
    private int roomId;
    private int days;
}
