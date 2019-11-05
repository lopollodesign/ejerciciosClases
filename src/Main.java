import trabajofinal.factory.TravelAgent;
import trabajofinal.models.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        TravelAgent travelAgent = initTravelAgent(false);
        initApp(travelAgent);
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

    private static void initApp(TravelAgent travelAgent) {
        HashMap<String, Travel> map = travelAgent.getRandomTravelsHashMap(6);
        App.showTravelList(map);
    }
}



//        System.out.println("¿Que quieres hacer?");
//        System.out.println("Fijate en los codigos, siempre es una letra de la opcion y el numero del viaje.");
//        Scanner scanner = new Scanner(System.in);
//        String hello = scanner.nextLine();
//        if (hello.equals("D1")) {
//            System.out.println("¿Seguro que quieres borrar el Viaje 1? [Y]es / [N]o");
//            hello = scanner.nextLine();
//            if (hello.equals("Y")) {
//                map.remove(1);
//                for (int index = 1 ; index < map.size() ; index++ ){
//                    if (map.containsKey(index)) {
//                        travelMap = map.get(index);
//                        showTravel(travelMap, index);
//                    }
//                }
//            } else {
//                System.out.println("Si, mejor no lo borres...");
//            }
//        } else {
//            System.out.println("El codigo " + hello + " no es valido ¿Que quieres hacer ahora?");
//            hello = scanner.nextLine();
//        }
//        App();
//        System.out.println("Has puesto \"" + hello + "\"");