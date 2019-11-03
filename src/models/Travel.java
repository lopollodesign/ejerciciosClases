package models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Travel{

    private Traveller traveller;
    private Connection connection;
    private List<Service> services;
    private Date checkOut;
    private int MAX_STAYDAYS = 15;

    public Travel() {
        this.checkOut = getRandomDateByDays(getRandomStayDays());
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Connection getConnection() {
        return connection;
    }

    public float getServicesPrice(){
        float totalPrice = 0;
        for (Service service: this.services){
            totalPrice += service.getPrice();
        }
        return totalPrice;
    }

    public int getRandomStayDays(){
        Random random = new Random();
        return random.nextInt(this.MAX_STAYDAYS);
    }

    private Date getRandomDateByDays(int days) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    @Override
    public String toString() {
        return "Trip to " + this.connection.getArrival().toString() + ". Traveller: " + this.traveller.toString();
    }
}
