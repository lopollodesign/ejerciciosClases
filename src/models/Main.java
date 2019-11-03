package models;

import factory.TravelAgent;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String SERIALIZABLE_PATH = "c:/json/";
        String SERIALIZABLE_FORMAT = "txt";

        TravelAgent travelAgent = new TravelAgent(SERIALIZABLE_PATH, SERIALIZABLE_FORMAT);
        // travelAgent.saveData("all");

        travelAgent.initData();
        // Travel myTravel = travelAgent.getRandomTravel();

        List<Travel> myTravels = travelAgent.getRandomTravelsList(6);
        // showTravelList(myTravels);

        HashMap<Integer, Travel> map = new HashMap<Integer, Travel>();

        int indexMap = 1;
        for (Travel travel: myTravels) {
            map.put(indexMap, travel);
            indexMap++;
        }

        Travel travelMap;
        for (int index = 1 ; index < map.size() ; index++ ){
            travelMap = map.get(index);
            showTravel(travelMap, index);
        }

        map.remove(2);

        for (int index = 1 ; index < map.size() ; index++ ){
            if (map.containsKey(index)) {
                travelMap = map.get(index);
                showTravel(travelMap, index);
            }
        }


//        Scanner scanner = new Scanner(System.in);
//        String hello = scanner.nextLine();
//        System.out.println("Has puesto \"" + hello + "\"");

    }

    private static void listToString(List objectsList, String listName) {
        String information;
        System.out.println(" ");
        System.out.println("-----------------");
        System.out.println(" ");
        System.out.println(listName.toUpperCase() + ":");
        System.out.println(" ");
        for (Object objectIndex : objectsList){
            information = objectIndex.toString();
            System.out.println(information);
        }
    }

    private static void showTravelList(List<Travel> list) {
        int index = 1;
        for (Travel travel : list) {
            showTravel(travel, index);
//            showTravelDetails(travel);
            index++;
        }
        System.out.println("----");
    }

    private static void showOptions(int indexTravel) {
        String deleteButton = createButton(indexTravel ,"D", "Delete travel " + indexTravel);
        String openButton = createButton(indexTravel ,"O", "Open travel " + indexTravel);
        System.out.println("Options " + openButton + deleteButton);
    }

    private static String createButton(int numIndex, String code, String text) {
        return "["+ code + numIndex + "-" + text +"] ";
    }

    private static void showTravel(Travel travel, int index) {
        System.out.println("----");
        System.out.println(" ");
        System.out.println("Travel " + index);
        System.out.println(travel);
        System.out.println("Price: " + prettyPrice(travel.getPrice()) + ". " + travel.getServices().size() + " Servicies");
        System.out.println(" ");
        showOptions(index);
        System.out.println(" ");
    }

    private static void showTravelDetails(Travel travel) {
        Connection connection = travel.getConnection();
        TransportType transportType = connection.getTransportType();

        System.out.println("===============");
        System.out.println(" ");

        System.out.println("Trip to " + travel.getDestination());
        System.out.println("Reservation for " + travel.getTraveller());
        System.out.println("(Total price: " + prettyPrice(travel.getPrice()) + ")");

        System.out.println(" ");
        System.out.println("----");
        System.out.println(" ");

        System.out.println("Connection (Total price: " + prettyPrice(connection.getPrice()) + ")");
        System.out.println("Departure: " + connection.getDeparture() + " - " + travel.getCheckIn());
        System.out.println("Arrival: " + connection.getArrival() + " - " + travel.getCheckOut());
        System.out.println("Transport type: "+ transportType + ". Distance: " + connection.getDistance() + "Km. Price per Km: " + transportType.getPricePerKm());

        System.out.println(" ");
        System.out.println("----");
        System.out.println(" ");

        System.out.println(travel.getServices().size() + " Servicies (Total price " + prettyPrice(travel.getServicesPrice()) + ")");
        System.out.println(" ");
        for (Service service : travel.getServices()){
            System.out.println((service.isHotel() ? "Hotel: " + service: "Activity: " + service));
            System.out.println("Price: " + prettyPrice(service.getPrice()));
            if (service.isHotel()) {
                Hotel hotel = (Hotel)service;
                System.out.println("(" + hotel.getStayDays() + " nights. Price per day " + prettyPrice(hotel.getDayPrice()) + ")");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println("===============");
    }

    public static String prettyPrice(float price){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(price) + " €";
    }
}
