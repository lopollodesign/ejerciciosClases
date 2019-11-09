import trabajofinal.factory.TravelAgent;
import trabajofinal.front.App;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        initApp(new TravelAgent(false), true);
    }

    private static void initApp(TravelAgent travelAgent, boolean initial) throws IOException {
        if (initial){
            App.showTravelList(travelAgent.getTravels());
        }

        Scanner scanner = new Scanner(System.in);
        String scannerIn = scanner.nextLine();

        if (TravelAgent.hasTravelOption(scannerIn, travelAgent.getTravels())) {
            travelAgent.doOption(scannerIn);
            initApp(travelAgent, false);
        } else {
            System.out.println("Esa opcion no existe. Vuelve a intentarlo");
            initApp(travelAgent, false);
        }

    }
}