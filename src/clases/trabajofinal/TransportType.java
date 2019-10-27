package clases.trabajofinal;

import java.util.ArrayList;
import java.util.List;

public class TransportType {
    private  String name;
    private float autonomy;
    private float pricePerKm;
    private float speed;

    private TransportType(String name, float autonomy, float pricePerKm, float speed){
        this.name = name;
        this.autonomy = autonomy;
        this.pricePerKm = pricePerKm;
        this.speed = speed;
    }

    private static TransportType getBike() {
        return new TransportType("Bike", 5f , 1f, 6f);
    }
    private static TransportType getBus(){
        return new TransportType("Bus", 40f , 5f, 18f);
    }
    private static TransportType getTrain(){
        return new TransportType("Train",  120f, 20f, 10f);
    }
    private static TransportType getBoat(){
        return new TransportType("Boat",  400f, 80f, 14f);
    }
    private static TransportType getAirPlane(){
        return new TransportType("Air plane",  840f, 5000f, 60f);
    }

    public List<TransportType> transportTypeList(){
        List<TransportType> transportTypeList = new ArrayList<>();

        TransportType bike = getBike();
        TransportType bus = getBus();
        TransportType train = getTrain();
        TransportType boat = getBoat();
        TransportType airPlane = getAirPlane();

        transportTypeList.add(bike);
        transportTypeList.add(bus);
        transportTypeList.add(train);
        transportTypeList.add(boat);
        transportTypeList.add(airPlane);

        return transportTypeList;
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
