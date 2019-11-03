package models;

import java.util.List;

public class Travel {
    private Traveller traveller;
    private Connection connection;
    private List<Booking> bookings;

    public Travel(Traveller traveller, Connection connection, List<Booking> bookings) {
        this.traveller = traveller;
        this.connection = connection;
        this.bookings = bookings;
    }
}
