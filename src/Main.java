import trabajofinal.factory.TravelAgent;
import trabajofinal.models.*;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        TravelAgent travelAgent = initTravelAgent(false);
        initApp(travelAgent, true);
    }

    private static TravelAgent initTravelAgent(boolean loadData){
        String SERIALIZABLE_PATH = "c:/json/";
        String SERIALIZABLE_FORMAT = "txt";
        TravelAgent travelAgent = new TravelAgent(SERIALIZABLE_PATH, SERIALIZABLE_FORMAT);
        if (loadData) {
            travelAgent.saveData("all");
        }
        travelAgent.initData();
        return travelAgent;
    }

    private static void initApp(TravelAgent travelAgent, boolean initial) throws IOException {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Travel> map;
//        map = Serial.loadHashMapTravelModel(SERIALIZABLE_PATH, SERIALIZABLE_FORMAT);
        map = travelAgent.getRandomTravelsHashMap(6);

        if (initial){
            // map = travelAgent.getRandomTravelsHashMap(6);
            // Serial.saveHashMapModel(map, SERIALIZABLE_PATH, "travels", SERIALIZABLE_FORMAT);
            App.showTravelList(map);
        }
        String scannerIn = scanner.nextLine();

        if (TravelAgent.hasTravelOption(scannerIn, map)) {
            TravelAgent.doOption(scannerIn);
        } else {
            System.out.println("Esa opcion no existe. Vuelve a intentarlo");
            initApp(travelAgent, false);
        }

    }
}