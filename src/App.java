import trabajofinal.models.*;
import trabajofinal.utils.Utils;

import java.util.HashMap;

public class App {


    // ESTO ESTABA AQUI CUANDO FUNCIONABA BIEN, AHORA ESTA EN EL TRAVEL AGENT Y NO FUNCIONA

//    private HashMap<Character, String> optionsCharacter = new HashMap<>();
//
//    public App() {
//        this.optionsCharacter.put('O', "Open");
//        this.optionsCharacter.put('D', "Delete");
//    }
//
//    public HashMap<Character, String> getHashMap() {
//        return optionsCharacter;
//    }
//
//    public boolean hasOptionCode(char letter) {
//        String clear = Character.toString(letter).toUpperCase();
//        return this.optionsCharacter.containsKey(clear.charAt(0));
//    }
//
//    public static boolean hasTravelOption(String in, HashMap<String, Travel> map){
//        App app = new App();
//        String key = in.substring(1);
//        return app.hasOptionCode(in.charAt(0)) && map.containsKey(key);
//    }

    static void showTravelList(HashMap<String, Travel> map) {
        StringBuilder sb = new StringBuilder();
        for (String locator : map.keySet()) {
            sb.append(simpleTravel(map.get(locator), locator)).append(getSign("intro--d"));
            sb.append(travelOptions(locator));
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

//private static void listToString(List objectsList, String listName) {
//    String information;
//    System.out.println();
//    System.out.println(getSign("s-lg"));
//    System.out.println();
//    System.out.println(listName.toUpperCase() + ":");
//    System.out.println();
//    for (Object objectIndex : objectsList){
//        information = objectIndex.toString();
//        System.out.println(information);
//    }
//    System.out.println(getSign("s-lg"));
//}