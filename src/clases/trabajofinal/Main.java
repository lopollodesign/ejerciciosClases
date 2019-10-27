package clases.trabajofinal;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // CREACION DE DATOS
        List<Destination> destinations = Arrays.asList(
                new Destination("Barcelona", new Point(3, 33)),
                new Destination("Madrid", new Point(6, 30)),
                new Destination("Valencia", new Point(9, 27)),
                new Destination("Palma", new Point(12, 24))
        );
        List<Hotel> hotels = Arrays.asList(
                new Hotel("Hotel Iberostar Mediterráneo", destinations.get(0)),
                new Hotel("Casa Nadal", destinations.get(0)),
                new Hotel("Hotel Príncipe Pío", destinations.get(1)),
                new Hotel("Madrid Motion Hotels", destinations.get(1)),
                new Hotel("Expo Hotel Valencia", destinations.get(2)),
                new Hotel("Meliá Valencia", destinations.get(2)),
                new Hotel("Hotel Abelay", destinations.get(3)),
                new Hotel("OLA Hotel", destinations.get(3))
        );
        List<Activity> activities = Arrays.asList(
                new Activity("Visita guiada al Parc Güell", destinations.get(0)),
                new Activity("Día en la Casa Batllò", destinations.get(0)),
                new Activity("Visita al Parque del retiro", destinations.get(1)),
                new Activity("Tour al Valle de los Caídos", destinations.get(1)),
                new Activity("Vuelta en bici por la Ciutat de les ciències", destinations.get(2)),
                new Activity("Tapas en el casco antiguo", destinations.get(2)),
                new Activity("Visita a La Seu", destinations.get(3)),
                new Activity("Excursión al Castell d'Alarò", destinations.get(3))
        );

        // OUTPUT
        listToString(destinations, "Destinations");
        listToString(hotels, "Hotels");
        listToString(activities, "Activities");
    }


    private static void listToString(List objectsList, String listName) {
        String information;
        System.out.println(" ");
        System.out.println("----------------- ");
        System.out.println(" ");
        System.out.println(listName + ":");
        for (Object objectIndex : objectsList){
            information = objectIndex.toString();
            System.out.println(information);
        }
    }
}
