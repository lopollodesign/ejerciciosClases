package factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Traveller;

import java.io.*;

public class Factory {

    public static void saveTraveller(Traveller traveller , String fileName ) {
        try {
            OutputStream fileOut = new FileOutputStream("c:/json/" + fileName + ".txt");
            Writer writer = new OutputStreamWriter(fileOut);
            Gson gson = new GsonBuilder().create();
            gson.toJson(traveller, writer);
            writer.close();
            fileOut.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    public static Traveller loadTraveller() throws IOException, ClassNotFoundException {
        InputStream fileIn = new FileInputStream("c:/json/hello.txt");
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();
        Traveller traveller = gson.fromJson(reader, Traveller.class);
        reader.close();
        return traveller;
    }

}
