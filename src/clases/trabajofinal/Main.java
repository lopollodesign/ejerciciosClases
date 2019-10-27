package clases.trabajofinal;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // CREACION DE DESTINOS RANDOM
        List<Destination> destinations = createDestinations();

        //OUTPUT
        listToString(destinations);
    }

    private static List<Destination> createDestinations() {

        return Arrays.asList(
                new Destination("Berlin", new Point(3, 33)),
                new Destination("Munich", new Point(6, 30)),
                new Destination("Paris", new Point(9, 27)),
                new Destination("Palma", new Point(12, 24)),
                new Destination("London", new Point(15, 21)),
                new Destination("Lyon", new Point(18, 18)),
                new Destination("Gijon", new Point(21, 15)),
                new Destination("Bogota", new Point(24, 12)),
                new Destination("Lima", new Point(27, 9)),
                new Destination("Hong Kong", new Point(30, 6)),
                new Destination("Madrid", new Point(33, 3)),
                new Destination("Manchester", new Point(36, 6)),
                new Destination("Luxemburgo", new Point(39, 9)),
                new Destination("Rabat", new Point(42, 12)),
                new Destination("Fez", new Point(45, 15)),
                new Destination("Dublín", new Point(48, 18)),
                new Destination("Tolousse", new Point(51, 21)),
                new Destination("Granada", new Point(54, 24)),
                new Destination("Santander", new Point(57, 27)),
                new Destination("Mahón", new Point(60, 30))
        );

    }

    private static void listToString(List objectsList) {
        String information;
        for (Object objectIndex : objectsList){
            information = objectIndex.toString();
            System.out.println(information);
        }
    }
}
