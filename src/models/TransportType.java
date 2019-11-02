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

    @Override
    public String toString(){
        return this.name;
    }
}
