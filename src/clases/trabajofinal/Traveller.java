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

    public void saveTraveller(Traveller traveller) {
//        FileOutputStream fop = null;
//        File file;
//        String content = "This is the text content";
//
//        try {
//            file = new File("c:/json/traveller.txt");
//            fop = new FileOutputStream(file);
//
//            if (!file.exists()){
//                file.createNewFile();
//            }
//
//            byte[] contentInBytes = content.getBytes();
//
//            fop.write(contentInBytes);
//            fop.flush();
//            fop.close();
//
//            System.out.println("Done");

        try {
            OutputStream fileOut = new FileOutputStream("c:/json/traveller.txt");
            Writer writer = new OutputStreamWriter(fileOut);
            Gson gson = new GsonBuilder().create();
            gson.toJson(traveller, writer);
            writer.close();
            fileOut.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    public Traveller loadTraveller() throws IOException, ClassNotFoundException {
        InputStream fileIn = new FileInputStream("/tmp/traveller.json");
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();
        Traveller traveller = gson.fromJson(reader, Traveller.class);
        reader.close();
        return traveller;
    }


    // Aqui suscribimos el metodo de equals() de la clase generica `Object` que es de java de forma generica
    @Override
    public boolean equals(Object obj) {
        // Si el `Object` que le pasamos es de tipo `Traveller` pasará el if()
        if (obj instanceof Traveller){


            // Creamos una variable de tipo `Traveller` pasando el objeto a este tipo de objeto
            Traveller objTraveller = (Traveller)obj;

            // Creamos el boolean con la condicion de que los nombres de los dos sean iguales, y no si son la misma instancia
            return this.name == objTraveller.name && this.lastName == objTraveller.lastName;
        }
        return false;
    }


}
