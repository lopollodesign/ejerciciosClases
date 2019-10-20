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
        sb.append(this.departure);
        sb.append(" hasta ");
        sb.append(this.arrival);
        sb.append(" (distancia: ");
        sb.append(this.distance);
        sb.append(")");
        return sb.toString();
    }

}
