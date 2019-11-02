package factory;

import models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelAgent {
    private String SERIALIZABLE_PATH;
    private String SERIALIZABLE_FORMAT;

    private Destination[] destinations;
    private Activity[] activities;
    private Hotel[] hotels;
    private Traveller[] travellers;
    private TransportType[] transportTypes;

    public TravelAgent(String path, String format) {
        this.SERIALIZABLE_PATH = path;
        this.SERIALIZABLE_FORMAT = format;
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

    public void saveData() {
        Serial.saveArrayModel(Arrays.asList(this.destinations), SERIALIZABLE_PATH, "destinations", SERIALIZABLE_FORMAT);
        Serial.saveArrayModel(Arrays.asList(this.hotels), SERIALIZABLE_PATH, "hotels", SERIALIZABLE_FORMAT);
        Serial.saveArrayModel(Arrays.asList(this.activities), SERIALIZABLE_PATH, "activities", SERIALIZABLE_FORMAT);
        Serial.saveArrayModel(Arrays.asList(this.travellers), SERIALIZABLE_PATH, "travellers", SERIALIZABLE_FORMAT);
        Serial.saveArrayModel(Arrays.asList(this.transportTypes), SERIALIZABLE_PATH, "transportTypes", SERIALIZABLE_FORMAT);
    }

    public Destination[] getDestinations() {
        return destinations;
    }

    public Travel createRandomTravel() {
        // createTravel
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
