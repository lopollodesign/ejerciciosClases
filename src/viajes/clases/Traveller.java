package viajes.clases;

import java.util.*;

public class Traveller {
    private String name;
    private String lastName;
    private float budget;

    private Destination departure;
    private Destination arrival;
    private TransportType transportType;

    private String[] NAMES = {"Paco", "Jose", "Sandra", "Antonio", "Juan", "Vicente", "Teo", "Margalida"};
    private String[] LAST_NAMES = {"Martinez Álvarez", "Garau Picornell", "Frutos Gonzalez"};
    private float[] BUDGETS = { 100.30f , 300.40f , 400.10f , 900.3f };

    public Traveller(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public void setDeparture(Destination departure) {
        this.departure = departure;
    }

    public void setArrival(Destination arrival) {
        this.arrival = arrival;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public float getBudget() {
        return budget;
    }

    public Destination getDeparture() {
        return departure;
    }

    public Destination getArrival() {
        return arrival;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public ArrayList<Traveller> createTravellers(int travellersAccount){
        ArrayList<Traveller> newTravellers = new ArrayList<>();
        Random random = new Random();
        Traveller newTraveller = new Traveller();

        for( int i = 0 ; i < travellersAccount ; ++i ){
            int randomNameIndex = random.nextInt(this.NAMES.length);
            int randomLastNameIndex = random.nextInt(this.LAST_NAMES.length);
            int randomBudgetIndex = random.nextInt(this.BUDGETS.length);

            newTraveller.setName(this.NAMES[randomNameIndex]);
            newTraveller.setLastName(this.LAST_NAMES[randomLastNameIndex]);
            newTraveller.setBudget(this.BUDGETS[randomBudgetIndex]);

            newTravellers.add(newTraveller);
        }

        return newTravellers;
    }
}
