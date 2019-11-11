package trabajofinal.front;

import trabajofinal.models.*;
import trabajofinal.utils.Utils;

import java.util.HashMap;

public class App {

    public static void showTravelList(HashMap<String, Travel> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(getSign("s-lg"));
        sb.append("Lista de Viajes ("+ map.size() +")\n");
        sb.append(getSign("s-lg")).append(getSign("intro"));
        int index = 1;
        for (String locator : map.keySet()) {
            sb.append(simpleTravel(map.get(locator), locator)).append(getSign("intro--d"));
            sb.append(travelOptions(locator));
            if (index == map.size()) {
                sb.append(getSign("intro"));
                sb.append(getSign("s-lg"));
            } else {
                sb.append(getSign("intro"));
                sb.append(getSign("s-xs"));
                sb.append(getSign("intro"));

            }
            index++;
        }
        System.out.println(sb.toString());

    }

    private static String travelOptions(String locator) {
        StringBuilder sb = new StringBuilder();
        sb.append("Options:\n");
        sb.append(createButton(locator, "D", "Delete travel")).append(getSign("intro"));
        sb.append(createButton(locator, "O", "Open travel")).append(getSign("intro"));
        return sb.toString();
    }

    private static String simpleTravel(Travel travel, String locator) {
        StringBuilder sb = new StringBuilder();
        sb.append(travelTitle(locator));
        sb.append(travel.simplePattern());
        return sb.toString();
    }

    public static String openTravel(Travel travel, String travelKey){
        Connection connection = travel.getConnection();
        TransportType transportType = connection.getTransportType();
        StringBuilder sb = new StringBuilder();

        sb.append(getSign("intro"));
        sb.append(getSign("intro"));
        sb.append(getSign("intro"));
        sb.append(getSign("intro"));
        sb.append(getSign("intro"));
        sb.append(getSign("intro"));

        sb.append(getSign("s-lg"));
        sb.append(getSign("intro"));

        // Heading
        sb.append(simpleTravel(travel, travelKey));

        sb.append(getSign("intro"));
        sb.append(getSign("s-xs"));
        sb.append(getSign("intro"));

        // Connection
        sb.append("Connection (Total price: " + Utils.prettyPrice(connection.getPrice()) + ")\n");
        sb.append("Departure: " + connection.getDeparture() + " - " + travel.getCheckIn() + "\n");
        sb.append("Arrival: " + connection.getArrival() + " - " + travel.getCheckOut() + "\n");
        sb.append("Transport type: "+ transportType + ". Distance: " + connection.getDistance() + "Km. Price per Km: " + transportType.getPricePerKm() + "\n");


        sb.append(getSign("intro"));
        sb.append(getSign("s-xs"));
        sb.append(getSign("intro"));

        // Servicies
        sb.append(travel.getServices().size() + " Servicies (Total price " + Utils.prettyPrice(travel.getServicesPrice()) + ")\n");
        for (Service service : travel.getServices()){
            sb.append("\n" + (service.isHotel() ? "Hotel: " + service: "Activity: " + service) + "\n");
            sb.append("Price: " + Utils.prettyPrice(service.getPrice()) + "\n");
            if (service.isHotel()) {
                Hotel hotel = (Hotel)service;
                sb.append("(" + hotel.getStayDays() + " nights. Price per day " + Utils.prettyPrice(hotel.getDayPrice()) + ")\n");
            }
        }

        sb.append(getSign("intro"));
        sb.append(getSign("s-lg"));
        return sb.toString();
    }

    public static String optionNoExist(String in) {
        StringBuilder sb = new StringBuilder();
        sb.append(getSign("s-lg"));
        sb.append("La option \"" + in + "\" no existe, introduce alguna válida\n");
        sb.append("(Visto como estamos, te recomiendo que copies y pegues para no equivocarte)\n");
        sb.append(getSign("s-lg"));
        return sb.toString();
    }

    private static String createButton(String locator, String code, String text) {
        return text + getSign("arrow") + getSquare(code + locator);
    }

    private static String travelTitle(String locator) {
        return "Travel " + getSquare(locator) + getSign("intro");
    }

    private static String getSquare(String content) {
        return "[" + content + "]";
    }

    public static String getSign(String type) {
        switch (type) {
            case "s-xs":
                return "---------------------------------------------------------------------------\n";
            case "s-md":
                return "···········································································";
            case "s-lg":
                return "===========================================================================\n";
            case "arrow":
                return " --> ";
            case "intro":
                return "\n";
            case "intro--d":
                return "\n\n";
        }
        return " ";
    }

    public static boolean confirmation(String question) {
        boolean responseBoolean;
        String response;
        int index = 0;

        do {
            StringBuilder sb = new StringBuilder();
            sb.append(getSign("intro"));
            sb.append(getSign("s-lg"));
            if (index > 0){
                System.out.println("Pon un valor válido...");
            }
            sb.append(question + getSign("intro"));
            sb.append(getSquare("Y") + "es - " + getSquare("N") + "o\n");
            sb.append(getSign("s-lg"));
            System.out.println(sb.toString());

            response = Utils.scanner().toLowerCase();
            index++;
            responseBoolean = response.equals("y");
        } while (!response.equals("y") && !response.equals("n"));


        return responseBoolean;
    }

}