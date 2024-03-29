package trabajofinal.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import trabajofinal.models.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;

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
}
