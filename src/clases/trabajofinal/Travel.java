package clases.trabajofinal;

public class Travel {
    private Destination departure;
    private Destination arrival;
    private float distance;

    public float getDistance() {
        return this.distance = departure.getDistance(arrival);
    }

}
