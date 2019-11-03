package models;

import java.util.Date;

public class Hotel extends Service {

    private Date checkIn;
    private Date checkOut;
    private int stayDays;
    private float dayPrice;

    public Hotel(String name, Destination destination) {
        super(name, destination);
    }

    private static int daysCalcuate(Date checkIn, Date checkOut) {
        long diff = checkOut.getTime() - checkIn.getTime();
        return (int) diff / 1000 / 60 / 60 / 24;
    }

    @Override
    public float getPrice() {
        return this.stayDays * this.dayPrice;
    }

    public int getStayDays() {
        return this.stayDays;
    }
}
