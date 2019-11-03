package models;

import java.util.Date;
import java.util.List;

public class Travel implements Bookable{
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
        return 3f;
    }

    @Override
    public float getPrice() {
        return 0;
    }
}
