package viajes.clases;

public class Travel {
    private Destination departure;
    private Destination arrival;
    private float distance;

    public Travel() {}

    public void setDeparture(Destination departure) {
        this.departure = departure;
    }

    public void setArrival(Destination arrival) {
        this.arrival = arrival;
    }

    public float getDistance() {
        return this.distance = departure.getDistance(arrival);
    }

    public float getPrice( TransportType transportType ) {
        float priceTransportType = transportType.getPricePerKm();
        return this.distance * priceTransportType;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" -- Travel: ");
        sb.append(this.departure);
        sb.append(" to ");
        sb.append(this.arrival);
        sb.append(". Distance: ");
        sb.append(this.distance);
        return sb.toString();
    }

}
