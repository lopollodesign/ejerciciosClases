package models;

import java.util.Date;
import java.util.List;

public class Travel{
    private Traveller traveller;
    private Connection connection;
    private List<Service> services;

    private Date checkIn;
    private Date checkOut;
    private float totalPrice;

    public Travel(Traveller traveller, Connection connection, List<Service> services) {
        this.traveller = traveller;
        this.connection = connection;
        this.services = services;
    }

    public float getConnectionPrice() {
        return connection.getPrice();
    }

    public float getServicesPrice(){
        float totalPrice = 0;
        for (Service service: this.services){
            totalPrice += service.getPrice();
        }
        return totalPrice;
    }

    public float getPrice() {
        return getConnectionPrice() + getServicesPrice();
    }
}
