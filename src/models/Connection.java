package models;

public class Connection{
    private Destination departure;
    private Destination arrival;
    private TransportType transportType;

    private float distance;
    private float price;

    public Connection(Destination departure, Destination arrival, TransportType transportType) {
        this.departure = departure;
        this.arrival = arrival;
        this.transportType = transportType;
        this.distance = getDistance();
        this.price = this.distance * transportType.getPricePerKm();
    }

    public float getDistance() {
        return this.distance = departure.getDistance(arrival);
    }

    public Destination getDeparture() {
        return departure;
    }

    public Destination getArrival() {
        return arrival;
    }

    public float getPrice(){
        return this.price;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    @Override
    public String toString() {
        return "Connection: " + this.departure + " to " + this.arrival;
    }
}