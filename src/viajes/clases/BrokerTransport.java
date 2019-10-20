package viajes.clases;

import java.util.Random;
import java.util.List;

public class BrokerTransport {

    private static void generateTravel( Traveller traveller , List<Destination> destinations){
        Random random = new Random();
        Travel newTravel = new Travel();
        int randomDepartureIndex = random.nextInt(destinations.size());
        Destination departure = destinations.get(randomDepartureIndex);
        newTravel.setDeparture(departure);

        destinations.remove(randomDepartureIndex);
        int randomArrivalIndex = random.nextInt(destinations.size());
        Destination arrival = destinations.get(randomArrivalIndex);
        newTravel.setArrival(arrival);

        traveller.setTravel(newTravel);
    }

    public static void assignTravel( List<Traveller> travellers , List<Destination> destinations){
        for (Traveller indexTraveller : travellers){
            generateTravel( indexTraveller , destinations );
        }
    }

    public static void assignTransportType( List<Traveller> travellers){
        TransportType transportType;
        Travel travel;
        float distance;
        float budget;
        float travelPrice;
        boolean isSufficientAutonomy;
        boolean isSufficientBudge;

        for (Traveller indexTraveller : travellers){

            travel = indexTraveller.getTravel();
            distance = travel.getDistance();
            budget = indexTraveller.getBudget();

            do {

                transportType = TransportType.createRandomTransportType();
                isSufficientAutonomy = transportType.getAutonomy() >= distance;
                if (isSufficientAutonomy) {

                    travelPrice = indexTraveller.getTravel().getPrice(transportType);
                    isSufficientBudge = travelPrice <= budget;
                    if (isSufficientBudge) {
                        indexTraveller.setTransportType(transportType);
                    }
                }

            } while (!indexTraveller.hasTransportType());

        }
    }

}
