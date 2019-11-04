package factory;

import models.*;

import java.io.IOException;
import java.util.*;

public class TravelAgent {
    private String SERIALIZABLE_PATH;
    private String SERIALIZABLE_FORMAT;

    private List<Destination> destinations;
    private List<Activity> activities;
    private List<Hotel> hotels;
    private List<Traveller> travellers;
    private List<TransportType> transportTypes;

    private Data data = new Data();

    public TravelAgent(String path, String format) {
        this.SERIALIZABLE_PATH = path;
        this.SERIALIZABLE_FORMAT = format;
    }

    public void saveData(String classType) {
        switch (classType) {
            case "destinations":
                Serial.saveArrayModel(data.getDestinations(), SERIALIZABLE_PATH, "destinations", SERIALIZABLE_FORMAT);
                break;
            case "hotels":
                Serial.saveArrayModel(data.getHotels(), SERIALIZABLE_PATH, "hotels", SERIALIZABLE_FORMAT);
                break;
            case "activities":
                Serial.saveArrayModel(data.getActivities(), SERIALIZABLE_PATH, "activities", SERIALIZABLE_FORMAT);
                break;
            case "travellers":
                Serial.saveArrayModel(data.getTravellers(), SERIALIZABLE_PATH, "travellers", SERIALIZABLE_FORMAT);
                break;
            case "transportTypes":
                Serial.saveArrayModel(data.getTransportTypes(), SERIALIZABLE_PATH, "transportTypes", SERIALIZABLE_FORMAT);
                break;
            default:
                Serial.saveArrayModel(data.getDestinations(), SERIALIZABLE_PATH, "destinations", SERIALIZABLE_FORMAT);
                Serial.saveArrayModel(data.getHotels(), SERIALIZABLE_PATH, "hotels", SERIALIZABLE_FORMAT);
                Serial.saveArrayModel(data.getActivities(), SERIALIZABLE_PATH, "activities", SERIALIZABLE_FORMAT);
                Serial.saveArrayModel(data.getTravellers(), SERIALIZABLE_PATH, "travellers", SERIALIZABLE_FORMAT);
                Serial.saveArrayModel(data.getTransportTypes(), SERIALIZABLE_PATH, "transportTypes", SERIALIZABLE_FORMAT);
        }
    }

    public void initData() {
        try {
            this.destinations = Serial.loadArrayDestinationModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        } catch (IOException ioEx){
            System.out.println("No hay datos de destinos");
        }
        try {
            this.activities = Serial.loadArrayActivityModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        } catch (IOException ioEx){
            System.out.println("No hay datos de Actividades");
        }
        try {
            this.hotels = Serial.loadArrayHotelModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        } catch (IOException ioEx){
            System.out.println("No hay datos de Hoteles");
        }
        try {
            this.travellers = Serial.loadArrayTravellerModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        } catch (IOException ioEx){
            System.out.println("No hay datos de Viajeros");
        }
        try {
            this.transportTypes = Serial.loadArrayTransportTypeModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        } catch (IOException ioEx){
            System.out.println("No hay datos de Tipos de Transporte");
        }
    }

    private static String getLocator() {
        Random random = new Random();
        String locator = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        locator += Integer.toString(random.nextInt(9));
        locator += Integer.toString(random.nextInt(9));
        locator += abc.charAt(random.nextInt(abc.length()));
        locator += abc.charAt(random.nextInt(abc.length()));
        return locator;
    }

    public HashMap<String,Travel> getRandomTravelsHashMap(int quantity) {
        HashMap<String, Travel> hashMap = new HashMap<>();
        String locator;
        for ( hashMap.size() ; hashMap.size() < quantity;) {
            locator = getLocator();
            if (!hashMap.containsKey(locator)){
                hashMap.put(getLocator(), getRandomTravel());
            }
        }
        return hashMap;
    }

    public List<Travel> getRandomTravelsList(int quantity) {
        List<Travel> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            list.add(getRandomTravel());
        }
        return list;
    }

    private Travel getRandomTravel() {
        Travel travel = new Travel();
        travel.setTraveller((Traveller)getRandomItemList(this.travellers));
        travel.setConnection(getRandomConnection());
        ArrayList<Service> services = getRandomServices(travel.getConnection().getArrival(), travel.getCheckOut());
        travel.setServices(services);
        return travel;
    }

    private static Object getRandomItemList(List list) {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    private Connection getRandomConnection() {
        TransportType transportType = (TransportType) getRandomItemList(this.transportTypes);
        Destination departure = (Destination) getRandomItemList(this.destinations);
        Destination arrival = (Destination) getRandomItemList(this.destinations);
        while (departure.equals(arrival)) {
            arrival = (Destination) getRandomItemList(this.destinations);
        }
        return new Connection(departure, arrival, transportType);
    }

    private Hotel getRandomHotel(Destination destination, Date checkOut) {
        Random random = new Random();
        ArrayList<Hotel> destinationHotels = new ArrayList<>();
        for (Hotel hotel : this.hotels) {
            if(hotel.destination.equals(destination)) {
                hotel.setCheckOut(checkOut);
                destinationHotels.add(hotel);
            }
        }
        int randomIndex = random.nextInt(destinationHotels.size());
        return destinationHotels.get(randomIndex);
    }

    private ArrayList<Activity> getDestinationActivities(Destination destination) {
        ArrayList<Activity> destinationActivities = new ArrayList<>();
        for (Activity activity : this.activities) {
            if(activity.destination.equals(destination)) {
                destinationActivities.add(activity);
            }
        }
        return destinationActivities;
    }

    private ArrayList<Activity> getRandomActivities(Destination destination) {
        ArrayList<Activity> destinationActivities = getDestinationActivities(destination);
        ArrayList<Activity> selectedActivities = new ArrayList<>();
        Activity addedActivity;
        Random random = new Random();
        int randomQuantity = random.nextInt(destinationActivities.size());
        int randomIndex;
        do {
            randomIndex = random.nextInt(destinationActivities.size());
            addedActivity = destinationActivities.get(randomIndex);
            if (!selectedActivities.contains(addedActivity)){
                selectedActivities.add(addedActivity);
            }
        } while ( selectedActivities.size() < randomQuantity );
        return selectedActivities;
    }

    private ArrayList<Service> getRandomServices(Destination destination, Date checkOut) {
        ArrayList<Service> servicesList = new ArrayList<>();
        servicesList.add(getRandomHotel(destination, checkOut));
        servicesList.addAll(getRandomActivities(destination));
        return servicesList;
    }

    public List<Travel> addTravel(Travel travel, List<Travel> travels){
        // Travel newTravel = createRandomTravel()
        // travels.add(newTravel)
        return travels;
    }

    public void deleteTravel(Travel travel){
        // delete travel
    }

    public List<Travel> getTravels(){
        return new ArrayList<Travel>();
    }

}
