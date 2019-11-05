import trabajofinal.models.*;
import trabajofinal.utils.Utils;

import java.util.HashMap;
import java.util.List;

public class App {

    private static void listToString(List objectsList, String listName) {
        String information;
        System.out.println();
        System.out.println(getSign("s-lg"));
        System.out.println();
        System.out.println(listName.toUpperCase() + ":");
        System.out.println();
        for (Object objectIndex : objectsList){
            information = objectIndex.toString();
            System.out.println(information);
        }
        System.out.println(getSign("s-lg"));
    }

    static void showTravelList(HashMap<String, Travel> map) {
        for (String locator : map.keySet()) {
            sbTravel(map.get(locator), locator);
            System.out.println(sbTravel(map.get(locator), locator) + getSign("intro"));
            showOptions(locator);
        }
        System.out.println(getSign("s-xs"));
    }

    private static void showOptions(String locator) {
        String deleteButton = createButton(locator ,"D", "Delete travel");
        String openButton = createButton(locator ,"O", "Open travel");
        System.out.println("Options:");
        System.out.println(openButton);
        System.out.println(deleteButton);
    }

    private static String sbTravel(Travel travel, String locator) {
        StringBuilder sb = new StringBuilder();
        sb.append(getSign("s-xs"));
        sb.append(travelTitle(locator));
        sb.append(travel.simplePattern());
        return sb.toString();
    }

    private static void showTravelDetails(Travel travel) {
        Connection connection = travel.getConnection();
        TransportType transportType = connection.getTransportType();

        System.out.println(getSign("s-lg"));
        System.out.println();

        System.out.println("Trip to " + travel.getDestination());
        System.out.println("Reservation for " + travel.getTraveller());
        System.out.println("(Total price: " + Utils.prettyPrice(travel.getPrice()) + ")");

        System.out.println();
        System.out.println(getSign("s-xs"));
        System.out.println();

        System.out.println("Connection (Total price: " + Utils.prettyPrice(connection.getPrice()) + ")");
        System.out.println("Departure: " + connection.getDeparture() + " - " + travel.getCheckIn());
        System.out.println("Arrival: " + connection.getArrival() + " - " + travel.getCheckOut());
        System.out.println("Transport type: "+ transportType + ". Distance: " + connection.getDistance() + "Km. Price per Km: " + transportType.getPricePerKm());

        System.out.println();
        System.out.println(getSign("s-xs"));
        System.out.println();

        System.out.println(travel.getServices().size() + " Servicies (Total price " + Utils.prettyPrice(travel.getServicesPrice()) + ")");
        System.out.println();
        for (Service service : travel.getServices()){
            System.out.println((service.isHotel() ? "Hotel: " + service: "Activity: " + service));
            System.out.println("Price: " + Utils.prettyPrice(service.getPrice()));
            if (service.isHotel()) {
                Hotel hotel = (Hotel)service;
                System.out.println("(" + hotel.getStayDays() + " nights. Price per day " + Utils.prettyPrice(hotel.getDayPrice()) + ")");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(getSign("s-lg"));
    }

    private static String createButton(String locator, String code, String text) {
        return text + getSign("arrow") + getSquare(code + locator);
    }

    private static String travelTitle(String locator) {
        return "Travel " + getSquare(locator) + getSign("intro--d");
    }

    private static String getSquare(String content) {
        return "[" + content + "] ";
    }

    private static String getSign(String type) {
        switch (type) {
            case "s-xs":
                return "--------\n";
            case "s-md":
                return "···········\n";
            case "s-lg":
                return "===============\n";
            case "arrow":
                return " --> ";
            case "intro":
                return "\n";
            case "intro--d":
                return "\n\n";
        }
        return " ";
    }
}
