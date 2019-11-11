import trabajofinal.factory.TravelAgent;
import trabajofinal.front.App;
import trabajofinal.models.Travel;
import trabajofinal.utils.Utils;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        initApp(new TravelAgent(true, travelsQuantity(true)), true);
    }

    private static int travelsQuantity(boolean initial) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            if (initial){
                System.out.println("Buenas!");
            }
            System.out.println("¿Cuantos viajes quieres crear?");
            System.out.println("(Recomendado de 3 a 10)");
            while (!sc.hasNextInt()) {
                System.out.println("Eso no es un numero ~~'");
                sc.next();
            }
            number = sc.nextInt();
        } while (number <= 0);

        return number;
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
                System.out.println(App.optionNoExist(scannerIn));
                initApp(travelAgent, false);
            }
        } else {
            System.out.println("La lista de viajes esta vacia");
            if (App.confirmation("¿Quieres crear de nuevo viajes aleatorios?")){
                travelAgent.resetTravels(travelsQuantity(false));
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