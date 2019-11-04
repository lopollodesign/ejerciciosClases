package models;

import factory.TravelAgent;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Este trozo entero, lo que esta en el Main Pasara a ser una App sola

        String SERIALIZABLE_PATH = "c:/json/";
        String SERIALIZABLE_FORMAT = "txt";
        TravelAgent travelAgent = new TravelAgent(SERIALIZABLE_PATH, SERIALIZABLE_FORMAT);
        // travelAgent.saveData("all");
        travelAgent.initData();

        HashMap<String, Travel> map = travelAgent.getRandomTravelsHashMap(6);
        showTravelList(map);

//        System.out.println("¿Que quieres hacer?");
//        System.out.println("Fijate en los codigos, siempre es una letra de la opcion y el numero del viaje.");
//        Scanner scanner = new Scanner(System.in);
//        String hello = scanner.nextLine();
//        if (hello.equals("D1")) {
//            System.out.println("¿Seguro que quieres borrar el Viaje 1? [Y]es / [N]o");
//            hello = scanner.nextLine();
//            if (hello.equals("Y")) {
//                map.remove(1);
//                for (int index = 1 ; index < map.size() ; index++ ){
//                    if (map.containsKey(index)) {
//                        travelMap = map.get(index);
//                        showTravel(travelMap, index);
//                    }
//                }
//            } else {
//                System.out.println("Si, mejor no lo borres...");
//            }
//        } else {
//            System.out.println("El codigo " + hello + " no es valido ¿Que quieres hacer ahora?");
//            hello = scanner.nextLine();
//        }
//        App();
//        System.out.println("Has puesto \"" + hello + "\"");
    }

    private static void App() {

    }

    private static void listToString(List objectsList, String listName) {
        String information;
        System.out.println();
        System.out.println("-----------------");
        System.out.println();
        System.out.println(listName.toUpperCase() + ":");
        System.out.println();
        for (Object objectIndex : objectsList){
            information = objectIndex.toString();
            System.out.println(information);
        }
    }

    private static void showTravelList(HashMap<String, Travel> map) {
        for (String key : map.keySet()) {
            showTravel(map.get(key), key);
        }
        System.out.println("----");
    }

    private static void showOptions(String indexTravel) {
        String deleteButton = createButton(indexTravel ,"D", "Delete travel");
        String openButton = createButton(indexTravel ,"O", "Open travel");
        System.out.println("Options:");
        System.out.println(openButton);
        System.out.println(deleteButton);
    }

    private static String createButton(String locator, String code, String text) {
        return text + ". Insert --> [" + code + locator + "] ";
    }

    private static void showTravel(Travel travel, String index) {
        System.out.println("----");
        System.out.println();
        System.out.println("Travel [" + index + "]");
        System.out.println(travel);
        System.out.println("Price: " + prettyPrice(travel.getPrice()) + ". " + travel.getServices().size() + " Servicies");
        System.out.println();
        showOptions(index);
        System.out.println();
    }

    private static void showTravelDetails(Travel travel) {
        Connection connection = travel.getConnection();
        TransportType transportType = connection.getTransportType();

        System.out.println("===============");
        System.out.println();

        System.out.println("Trip to " + travel.getDestination());
        System.out.println("Reservation for " + travel.getTraveller());
        System.out.println("(Total price: " + prettyPrice(travel.getPrice()) + ")");

        System.out.println();
        System.out.println("----");
        System.out.println();

        System.out.println("Connection (Total price: " + prettyPrice(connection.getPrice()) + ")");
        System.out.println("Departure: " + connection.getDeparture() + " - " + travel.getCheckIn());
        System.out.println("Arrival: " + connection.getArrival() + " - " + travel.getCheckOut());
        System.out.println("Transport type: "+ transportType + ". Distance: " + connection.getDistance() + "Km. Price per Km: " + transportType.getPricePerKm());

        System.out.println();
        System.out.println("----");
        System.out.println();

        System.out.println(travel.getServices().size() + " Servicies (Total price " + prettyPrice(travel.getServicesPrice()) + ")");
        System.out.println();
        for (Service service : travel.getServices()){
            System.out.println((service.isHotel() ? "Hotel: " + service: "Activity: " + service));
            System.out.println("Price: " + prettyPrice(service.getPrice()));
            if (service.isHotel()) {
                Hotel hotel = (Hotel)service;
                System.out.println("(" + hotel.getStayDays() + " nights. Price per day " + prettyPrice(hotel.getDayPrice()) + ")");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("===============");
    }

    public static String prettyPrice(float price){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(price) + " €";
    }
}
