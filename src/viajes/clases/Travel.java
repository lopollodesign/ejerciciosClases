package viajes.clases;

public class Travel {
    private Destination departure;
    private Destination arrival;
    private float price;
    private TransportType transportType;


    public Travel(Destination departure, Destination arrival, float price, TransportType transportType) {
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.transportType = transportType;
    }

}
