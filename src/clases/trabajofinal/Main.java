package clases.trabajofinal;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // CREACION DE DESTINOS RANDOM
        List<Destination> destinations = new Destination().createDestinations();

        //OUTPUT
        listToString(destinations);
    }

    private static void listToString(List objectsList) {
        String information;
        for (Object objectIndex : objectsList){
            information = objectIndex.toString();
            System.out.println(information);
        }
    }
}
