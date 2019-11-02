package models;

import factory.Factory;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String SERIALIZABLE_PATH = "c:/json/";
        String SERIALIZABLE_FORMAT = "txt";

//        Factory.saveArrayModel(destinations, SERIALIZABLE_PATH, "destinations", SERIALIZABLE_FORMAT);
//        Factory.saveArrayModel(hotels, SERIALIZABLE_PATH, "hotels", SERIALIZABLE_FORMAT);
//        Factory.saveArrayModel(activities, SERIALIZABLE_PATH, "activities", SERIALIZABLE_FORMAT);
//        Factory.saveArrayModel(travellers, SERIALIZABLE_PATH, "travellers", SERIALIZABLE_FORMAT);
//        Factory.saveArrayModel(transportTypes, SERIALIZABLE_PATH, "transportTypes", SERIALIZABLE_FORMAT);

        // DESERIALIZACION
        Destination[] destinations = Factory.loadArrayDestinationModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        Activity[] activities = Factory.loadArrayActivityModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        Hotel[] hotels = Factory.loadArrayHotelModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        Traveller[] travellers = Factory.loadArrayTravellerModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        TransportType[] transportTypes = Factory.loadArrayTransportTypeModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);

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
