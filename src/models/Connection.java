package models;

public class Connection {
    private Destination departure;
    private Destination arrival;
    private TransportType transportType;

    private float distance;
    private float price;

    public Connection(Destination departure, Destination arrival, TransportType transportType) {
        this.departure = departure;
        this.arrival = arrival;
        this.transportType = transportType;
    }

    public float getDistance() {
        return this.distance = departure.getDistance(arrival);
    }

    @Override
    public String toString() {
        return "Connection: " + this.departure + " to " + this.arrival;
    }
}