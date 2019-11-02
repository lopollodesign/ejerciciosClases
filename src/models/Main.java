package models;

import factory.Serial;

import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String SERIALIZABLE_PATH = "c:/json/";
        String SERIALIZABLE_FORMAT = "txt";

//        Serial.saveArrayModel(destinations, SERIALIZABLE_PATH, "destinations", SERIALIZABLE_FORMAT);
//        Serial.saveArrayModel(hotels, SERIALIZABLE_PATH, "hotels", SERIALIZABLE_FORMAT);
//        Serial.saveArrayModel(activities, SERIALIZABLE_PATH, "activities", SERIALIZABLE_FORMAT);
//        Serial.saveArrayModel(travellers, SERIALIZABLE_PATH, "travellers", SERIALIZABLE_FORMAT);
//        Serial.saveArrayModel(transportTypes, SERIALIZABLE_PATH, "transportTypes", SERIALIZABLE_FORMAT);

        // DESERIALIZACION
        Destination[] destinations = Serial.loadArrayDestinationModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        Activity[] activities = Serial.loadArrayActivityModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        Hotel[] hotels = Serial.loadArrayHotelModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        Traveller[] travellers = Serial.loadArrayTravellerModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        TransportType[] transportTypes = Serial.loadArrayTransportTypeModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);

        // OUTPUT
        listToString(Arrays.asList(destinations), "Destinations");
        listToString(Arrays.asList(hotels), "Hotels");
        listToString(Arrays.asList(activities), "Activities");
        listToString(Arrays.asList(travellers), "Travellers");
        listToString(Arrays.asList(transportTypes), "Transport Types");
    }


    private static void listToString(List objectsList, String listName) {
        String information;
        System.out.println(" ");
        System.out.println("----------------- ");
        System.out.println(" ");
        System.out.println(listName.toUpperCase() + ":");
        System.out.println(" ");
        for (Object objectIndex : objectsList){
            information = objectIndex.toString();
            System.out.println(information);
        }
    }
}
