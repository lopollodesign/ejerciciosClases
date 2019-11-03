package models;

import factory.Serial;
import factory.TravelAgent;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String SERIALIZABLE_PATH = "c:/json/";
        String SERIALIZABLE_FORMAT = "txt";

        TravelAgent travelAgent = new TravelAgent(SERIALIZABLE_PATH, SERIALIZABLE_FORMAT);
        travelAgent.initData();

        List<Destination> allDestinations = Serial.loadArrayDestinationModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        List<Hotel> allHotels = Serial.loadArrayHotelModel(SERIALIZABLE_PATH,SERIALIZABLE_FORMAT);
        listToString(allHotels, "hotels");
        listToString(allDestinations, "destinos");

        ArrayList<Activity> myActivities = travelAgent.getRandomActivities(allDestinations.get(0));
        listToString(myActivities, "actividades");

        Date myDate = new Date();
        Date newDate = getRandomDates(myDate,3);
        Date newDate2 = getRandomDates(myDate,103);

        System.out.println("myDate: " + myDate);
        System.out.println("newDate: " + newDate);
        System.out.println("newDate2: " + newDate2);
    }

    private static Date getRandomDates(Date date , int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
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
