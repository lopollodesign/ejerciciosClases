import trabajofinal.factory.TravelAgent;
import trabajofinal.models.*;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
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

    private static void initApp(TravelAgent travelAgent, boolean initial) {
        HashMap<Character, String> optionsTravels = travelAgent.getHashMap();
        Scanner scanner = new Scanner(System.in);

        // ERROR: Al iniciarse mas abajo la app se vuelve a iniciar este Mapa, hay que guardalo ya en el Json, porque sino siempre sera diferente
        HashMap<String, Travel> map = travelAgent.getRandomTravelsHashMap(6);
        if (initial){
            App.showTravelList(map);
        }
        String scannerIn = scanner.nextLine();
        if (TravelAgent.hasTravelOption(scannerIn, map)) {
            System.out.println("Estas dentro");
        } else {
            System.out.println("Esa opcion no existe. Vuelve a intentarlo");
            initApp(travelAgent, false);
        }

    }
}