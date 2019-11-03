package factory;

import models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TravelAgent {
    private String SERIALIZABLE_PATH;
    private String SERIALIZABLE_FORMAT;

    private List<Destination> destinations;
    private List<Activity> activities;
    private List<Hotel> hotels;
    private List<Traveller> travellers;
    private List<TransportType> transportTypes;

    public TravelAgent(String path, String format) {
        this.SERIALIZABLE_PATH = path;
        this.SERIALIZABLE_FORMAT = format;
    }

    public void saveData(String classType) {
        switch (classType) {
            case "destinations":
                Serial.saveArrayModel(this.destinations, SERIALIZABLE_PATH, "destinations", SERIALIZABLE_FORMAT);
            case "hotels":
                Serial.saveArrayModel(this.hotels, SERIALIZABLE_PATH, "hotels", SERIALIZABLE_FORMAT);
            case "activities":
                Serial.saveArrayModel(this.activities, SERIALIZABLE_PATH, "activities", SERIALIZABLE_FORMAT);
            case "travellers":
                Serial.saveArrayModel(this.travellers, SERIALIZABLE_PATH, "travellers", SERIALIZABLE_FORMAT);
            case "transportTypes":
                Serial.saveArrayModel(this.transportTypes, SERIALIZABLE_PATH, "transportTypes", SERIALIZABLE_FORMAT);
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

    private Object getRandomItemList(List list) {
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

    private Hotel getRandomHotel(Destination destination) {
        Random random = new Random();
        ArrayList<Hotel> destinationHotels = new ArrayList<Hotel>();
        for (Hotel hotel : this.hotels) {
            if(hotel.destination.equals(destination)) {
                destinationHotels.add(hotel);
            }
        }
        int randomIndex = random.nextInt(destinationHotels.size());
        return destinationHotels.get(randomIndex);
    }

    private ArrayList<Activity> getDestinationActivities(Destination destination) {
        ArrayList<Activity> destinationActivities = new ArrayList<Activity>();
        for (Activity activity : this.activities) {
            if(activity.destination.equals(destination)) {
                destinationActivities.add(activity);
            }
        }
        return destinationActivities;
    }

    public ArrayList<Activity> getRandomActivities(Destination destination) {
        ArrayList<Activity> destinationActivities = getDestinationActivities(destination);
        ArrayList<Activity> selectedActivities = new ArrayList<Activity>();
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

    public Travel createRandomTravel() {
        Traveller traveller = (Traveller)getRandomItemList(this.travellers);
        Connection connection = getRandomConnection();
        return new Travel();
    }

    public Travel[] addTravel(Travel travel, Travel[] travels){
        // Travel newTravel = createRandomTravel()
        // travels.add(newTravel)
        return travels;
    }

    public void deleteTravel(Travel travel){
        // delete travel
    }

    public List getTravels(){
        return new ArrayList<Travel>();
    }

}
