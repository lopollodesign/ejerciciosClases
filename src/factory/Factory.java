package factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Factory {

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
