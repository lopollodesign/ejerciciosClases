package models;

import factory.Data;
import factory.TravelAgent;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String SERIALIZABLE_PATH = "c:/json/";
        String SERIALIZABLE_FORMAT = "txt";

        TravelAgent travelAgent = new TravelAgent(SERIALIZABLE_PATH, SERIALIZABLE_FORMAT);
        //travelAgent.saveData("all");
        travelAgent.initData();
        Travel myTravel = travelAgent.getRandomTravel();

        System.out.println(myTravel);

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
