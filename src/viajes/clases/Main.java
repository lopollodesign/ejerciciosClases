package viajes.clases;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // CREACION DE DATOS RANDOM
        List<Destination> destinations = new Destination().createDestinations();
        List<Traveller> travellers = new Traveller().createTravellers(5);
        BrokerTransport.assignTravel(travellers, destinations);
        BrokerTransport.assignTransportType(travellers);

        //OUTPUT
        listToString(travellers);
    }

    private static void listToString(List objectsList) {
        String information;
        for (Object objectIndex : objectsList){
            information = objectIndex.toString();
            System.out.println(information);
        }
    }

}
