package trabajofinal.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import trabajofinal.models.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serial {

    public static void saveArrayModel(List objects , String folderPath , String fileName, String fileFormat) {
        try {
            OutputStream fileOut = new FileOutputStream(folderPath + fileName + "." + fileFormat);
            Writer writer = new OutputStreamWriter(fileOut);
            Gson gson = new GsonBuilder().create();
            gson.toJson(objects, writer);
            writer.close();
            fileOut.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    public static void saveHashMapModel(HashMap<String, Travel> hashMap, String folderPath , String fileName, String fileFormat) {
        try {
            OutputStream fileOut = new FileOutputStream(folderPath + fileName + "." + fileFormat);
            Writer writer = new OutputStreamWriter(fileOut);
            Gson gson = new GsonBuilder().create();
            gson.toJson(hashMap, writer);
            writer.close();
            fileOut.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    public static HashMap<String, Travel> loadHashMapTravelModel(String folderPath , String fileFormat) throws IOException {
        InputStream fileIn = new FileInputStream(folderPath + "travels." + fileFormat);
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();


        // Alomejor puedo hacer alguna chapuza como que tenga un atributo que sea el Key...
        // ...que al extraerlo pasarlo por un metodo que cree un hashMap al que le pone ese atributo al Key...??
        Type type = new TypeToken<Map<String, Travel>>(){}.getType();
        Map<String, Travel> myMap = gson.fromJson("{'k1':'apple','k2':'orange'}", type);

        // HashMap<String, Travel> hashMap = gson.fromJson(reader, (Type) Map.class);

        reader.close();
        return (HashMap<String, Travel>) myMap;
    }

    public static List<Destination> loadArrayDestinationModel(String folderPath , String fileFormat) throws IOException {
        InputStream fileIn = new FileInputStream(folderPath + "destinations." + fileFormat);
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();
        List<Destination> list = Arrays.asList(gson.fromJson(reader, Destination[].class));
        reader.close();
        return list;

    }

    public static List<Hotel> loadArrayHotelModel(String folderPath , String fileFormat) throws IOException {
        InputStream fileIn = new FileInputStream(folderPath + "hotels." + fileFormat);
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();
        List<Hotel> list = Arrays.asList(gson.fromJson(reader, Hotel[].class));
        reader.close();
        return list;
    }

    public static List<Activity> loadArrayActivityModel(String folderPath , String fileFormat) throws IOException {
        InputStream fileIn = new FileInputStream(folderPath + "activities." + fileFormat);
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();
        List<Activity> list = Arrays.asList(gson.fromJson(reader, Activity[].class));
        reader.close();
        return list;
    }

    public static List<Traveller> loadArrayTravellerModel(String folderPath , String fileFormat) throws IOException {
        InputStream fileIn = new FileInputStream(folderPath + "travellers." + fileFormat);
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();
        List<Traveller> list = Arrays.asList(gson.fromJson(reader, Traveller[].class));
        reader.close();
        return list;
    }

    public static List<TransportType> loadArrayTransportTypeModel(String folderPath , String fileFormat) throws IOException {
        InputStream fileIn = new FileInputStream(folderPath + "transporttypes." + fileFormat);
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();
        List<TransportType> list = Arrays.asList(gson.fromJson(reader, TransportType[].class));
        reader.close();
        return list;
    }

    public static List<Travel> loadArrayTravelModel(String folderPath , String fileFormat) throws IOException {
        InputStream fileIn = new FileInputStream(folderPath + "travels." + fileFormat);
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();
        List<Travel> list = Arrays.asList(gson.fromJson(reader, Travel[].class));
        reader.close();
        return list;
    }

    // ==================================
    // Con objetos simples
    // ==================================

    public static void saveModel(Object object , String folderPath , String fileName, String fileFormat) {
        try {
            OutputStream fileOut = new FileOutputStream(folderPath + fileName + "." + fileFormat);
            Writer writer = new OutputStreamWriter(fileOut);
            Gson gson = new GsonBuilder().create();
            gson.toJson(object, writer);
            writer.close();
            fileOut.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
    public static <T> T loadModel(String folderPath , String fileName, String fileFormat , Class<T> classType) throws IOException {
        InputStream fileIn = new FileInputStream(folderPath + fileName + "." + fileFormat);
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();
        T t = (T)gson.fromJson(reader, classType);
        reader.close();
        return t;
    }

}
