package models;

import java.util.Date;

public class Booking {

    // Datos de la reserva
    private Date checkIn;
    private Date checkOut;
    private int stayDays;

    private float dayPrice;
    private float totalPrice;

    private Service service;

    public Booking(Service service) {
        this.service = service;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    private static int daysCalcuate(Date checkIn, Date checkOut) {
        long diff = checkOut.getTime() - checkIn.getTime();
        return (int) diff / 1000 / 60 / 60 / 24;
    }

    @Override
    public String toString() {
        return this.service + " || " + this.checkIn + " - " + this.checkOut + ". Total Days: " + this.stayDays + ". Total Price: " + this.totalPrice;
    }
}
