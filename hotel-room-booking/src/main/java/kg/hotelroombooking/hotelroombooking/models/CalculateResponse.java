package kg.hotelroombooking.hotelroombooking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CalculateResponse {
    private double totalPrice;
    private Hotel hotel;
    private int days;
}
