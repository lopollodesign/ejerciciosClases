package clases.trabajofinal;

import java.io.*;

import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Traveller implements Serializable {

    private String name;
    private String lastName;
    private Date birthday;

    public Traveller(String name, String lastName, Date birthday) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    private void saveTraveller(Traveller traveller) {
        try {
            OutputStream fileOut = new FileOutputStream("/tmp/traveller.json");
            Writer writer = new OutputStreamWriter(fileOut);
            Gson gson = new GsonBuilder().create();
            gson.toJson(traveller, writer);
            writer.close();
            fileOut.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

}
