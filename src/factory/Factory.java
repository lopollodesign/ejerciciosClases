package factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Factory {

    public static void saveModel(Object object , String fileName ) {
        try {
            OutputStream fileOut = new FileOutputStream("c:/json/" + fileName + ".txt");
            Writer writer = new OutputStreamWriter(fileOut);
            Gson gson = new GsonBuilder().create();
            gson.toJson(object, writer);
            writer.close();
            fileOut.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    public static <T> T loadModel(String fileName , Class<T> classType) throws IOException {
        InputStream fileIn = new FileInputStream("c:/json/" + fileName + ".txt");
        Reader reader = new InputStreamReader(fileIn);
        Gson gson = new GsonBuilder().create();
        T t = (T)gson.fromJson(reader, classType);
        reader.close();
        return t;
    }

}
