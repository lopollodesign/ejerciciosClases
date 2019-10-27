package clases.trabajofinal;

import java.util.Date;

public class Booking {

    // Datos de la reserva
    private Date checkIn;
    private Date checkOut;
    private int stayDays;

    private float dayPrice;
    private float totalPrice;

    // Le añadimos un servicio
    Service service;

    private static int daysCalcuate(Date checkIn, Date checkOut) {
        long diff = checkOut.getTime() - checkIn.getTime();
        return (int) diff / 1000 / 60 / 60 / 24;
    }

}
