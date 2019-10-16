package viajes.clases;

import java.util.Random;

public class TransportType {
    private  String name;
    private float autonomy;
    private float pricePerKm;
    private float speed;

    public TransportType(String name, float autonomy, float pricePerKm, float speed){
        this.name = name;
        this.autonomy = autonomy;
        this.pricePerKm = pricePerKm;
        this.speed = speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setAutonomy(float autonomy) {
        this.autonomy = autonomy;
    }

    public String getName() {
        return name;
    }

    public float getPricePerKm() {
        return pricePerKm;
    }

    public float getSpeed() {
        return speed;
    }

    public float getAutonomy() {
        return autonomy;
    }

    public TransportType getCar(){
        return new TransportType("car", 10f , 10f, 200f);
    }

    public static TransportType createRandomTransportType(){
        Random random = new Random();
        int randomValue = random.nextInt(5);
        switch (randomValue) {
            case 0:

        }
        return null;
    }
}
