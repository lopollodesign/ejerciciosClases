package viajes.clases;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // CREACION DE DATOS RANDOM
        ArrayList<Destination> destinations = new Destination().createDestinations();
        ArrayList<Traveller> travellers = new Traveller().createTravellers(5);

        //OUTPUT
        listToStringTravellers(travellers);
        listToStringDestination(destinations);
    }

    private static void listToStringDestination(ArrayList<Destination> objectsList) {
        String information;
        for (Object objectIndex : objectsList){
            information = objectIndex.toString();
            System.out.println(information);
        }
    }

    private static void listToStringTravellers(ArrayList<Traveller> objectsList) {
        String information;
        for (Object objectIndex : objectsList){
            information = objectIndex.toString();
            System.out.println(information);
        }
    }

}
