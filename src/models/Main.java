package models;

import factory.TravelAgent;

import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String SERIALIZABLE_PATH = "c:/json/";
        String SERIALIZABLE_FORMAT = "txt";

        TravelAgent travelAgent = new TravelAgent(SERIALIZABLE_PATH, SERIALIZABLE_FORMAT);
        travelAgent.initData();
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
