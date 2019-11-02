package models;

public abstract class Connection {
    private Destination departure;
    private Destination arrival;

    private TransportType transportType;
    private float distance;
    private float price;

    public float getDistance() {
        return this.distance = departure.getDistance(arrival);
    }

    @Override
    public String toString() {
        return "Connection: " + this.departure + " to " + this.arrival;
    }
}