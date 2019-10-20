package viajes.clases;

import java.util.ArrayList;
import java.util.List;
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

    private static TransportType getWalking() {
        return new TransportType("walking", 5f , 1f, 6f);
    }

    private static TransportType getHorse(){
        return new TransportType("horse", 40f , 5f, 18f);
    }

    private static TransportType getCarriage(){
        return new TransportType("carriage",  120f, 20f, 10f);
    }

    private static TransportType getBoat(){
        return new TransportType("boat",  400f, 80f, 14f);
    }

    private static TransportType getDragon(){
        return new TransportType("dragon",  840f, 5000f, 60f);
    }

    public static TransportType createRandomTransportType(){
        Random random = new Random();
        int randomValue = random.nextInt(4);
        switch (randomValue) {
            case 0:
                return getHorse();
            case 1:
                return getCarriage();
            case 2:
                return getBoat();
            case 3:
                return getDragon();
            case 4:
                return getWalking();
            default:
                return getWalking();
        }
    }

    public List<TransportType> transportTypeList(){
        List<TransportType> transportTypeList = new ArrayList<TransportType>();

        TransportType walking = getWalking();
        TransportType horse = getHorse();
        TransportType carriage = getCarriage();
        TransportType boat = getBoat();
        TransportType dragon = getDragon();

        transportTypeList.add(walking);
        transportTypeList.add(horse);
        transportTypeList.add(carriage);
        transportTypeList.add(boat);
        transportTypeList.add(dragon);

        return transportTypeList;
    }

    public float getAutonomy() {
        return autonomy;
    }

    public float getPricePerKm() {
        return pricePerKm;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
