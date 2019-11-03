package models;

import java.util.Date;
import java.util.List;

public class Travel{
    private Traveller traveller;
    private Connection connection;
    private List<Booking> bookings;

    private Date checkIn;
    private Date checkOut;
    private float totalPrice;

    public Travel(Traveller traveller, Connection connection, List<Booking> bookings) {
        this.traveller = traveller;
        this.connection = connection;
        this.bookings = bookings;
    }

    public float getConnectionPrice() {
        return connection.getPrice();
    }

    public float getBookingPrice(Booking booking){
        return booking.getService().getPrice();
    }

    public float getBookingsPrice(){
        float totalPrice = 0;
        for (Booking booking: this.bookings){
            totalPrice += booking.getService().getPrice();
        }
        return totalPrice;
    }

    public float getPrice() {
        return getConnectionPrice() + getBookingsPrice();
    }
}
