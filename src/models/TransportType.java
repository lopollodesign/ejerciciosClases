package models;

public class TransportType {
    private  String name;
    private float pricePerKm;
    private float speed;

    public TransportType(String name, float pricePerKm, float speed){
        this.name = name;
        this.pricePerKm = pricePerKm;
        this.speed = speed;
    }

    public float getPricePerKm() {
        return pricePerKm;
    }

    public float getPrice( TransportType transportType ) {


        // Pendiente de cálculo
        float distance = 3.4f;


        float priceTransportType = transportType.getPricePerKm();
        return distance * priceTransportType;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
