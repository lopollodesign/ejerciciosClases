import trabajofinal.factory.TravelAgent;
import trabajofinal.front.App;
import trabajofinal.models.Travel;
import trabajofinal.utils.Utils;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        initApp(new TravelAgent(false), true);
    }

    private static void initApp(TravelAgent travelAgent, boolean showTravels) throws IOException {
        if (travelAgent.getTravels().size() > 0) {
            if (showTravels){
                App.showTravelList(travelAgent.getTravels());
            }

            System.out.println("Muy bien, fíjate en los códigos de opciones en los viajes.");
            System.out.println("¿Qué quieres haser?");

            String scannerIn = Utils.scanner();
            if (TravelAgent.hasTravelOption(scannerIn, travelAgent.getTravels())) {
                doOption(travelAgent, scannerIn);
            } else {
                System.out.println("Esa opcion no existe. Vuelve a intentarlo");
                System.out.println("(Visto como estamos, te recomiendo que copies y pegues para no equivocarte)");
                initApp(travelAgent, false);
            }
        } else {
            System.out.println("La lista de viajes esta vacia");
            if (App.confirmation("¿Quieres crear de nuevo viajes aleatorios?")){
                travelAgent.resetTravels();
                initApp(travelAgent, true);
            } else {
                System.out.println("Pues no hay mucho más que hacer aquí... Hasta nunqui");
            }
        }
    }

    public static void doOption(TravelAgent travelAgent, String key) throws IOException {
        HashMap<String , Travel> travels = travelAgent.getTravels();
        Character typeOption = key.charAt(0);
        String travelKey = key.substring(1);
        String nameOption = travelAgent.getHashMapOptions().get(typeOption);
        switch (nameOption){
            case "Open":
                System.out.println(App.openTravel(travels.get(travelKey), travelKey));
                initApp(travelAgent, false);
                break;
            case "Delete":
                System.out.println(travelAgent.deleteTravel(travels.get(travelKey), travelKey));
                initApp(travelAgent, true);
                break;
        }
    }
}