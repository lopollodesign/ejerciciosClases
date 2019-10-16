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
        for( int i = 0 ; i < travellersAccount ; ++i ){
            Traveller newTraveller = new Traveller();
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-12s", this.name));
        sb.append(String.format("%-12s", this.lastName));
        sb.append(String.format("%10.2f", this.budget));
        return sb.toString();
    }

    // Aqui suscribimos el metodo de equals() de la clase generica `Object` que es de java de forma generica
    @Override
    public boolean equals(Object obj) {
        // Si el `Object` que le pasamos es de tipo `Traveller` pasará el if()
        if (obj instanceof Traveller){
            // Creamos una variable de tipo `Traveller` pasando el objeto a este tipo de objeto
            Traveller objTraveller = (Traveller)obj;
            // Creamos el boolean con la condicion de que los nombres de los dos sean iguales, y no si son la misma instancia
            return this.name == objTraveller.name && this.lastName == objTraveller.lastName;
        }
        return false;
    }

}
