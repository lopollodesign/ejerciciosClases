package viajes.clases;

import java.util.*;

public class Traveller {
    private String name;
    private String lastName;
    private float budget;

    private TransportType transportType;
    private Travel travel;

    private String[] NAMES = {"Paco", "Jose", "Sandra", "Antonio", "Juan", "Vicente", "Teo", "Margalida"};
    private String[] LAST_NAMES = {"Martinez Álvarez", "Garau Picornell", "Frutos Gonzalez"};

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

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public Travel getTravel() {
        return travel;
    }

    public float getBudget() {
        return budget;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public boolean hasTransportType(){
        return this.transportType != null;
    }

    List<Traveller> createTravellers(int travellersAccount){
        List<Traveller> newTravellers = new ArrayList<>();
        Random random = new Random();
        for( int i = 0 ; i < travellersAccount ; ++i ){
            Traveller newTraveller = new Traveller();
            int randomNameIndex = random.nextInt(this.NAMES.length);
            int randomLastNameIndex = random.nextInt(this.LAST_NAMES.length);
            float randomBudget = 20.0f + random.nextFloat() * (2000f - 20f);
            newTraveller.setName(this.NAMES[randomNameIndex]);
            newTraveller.setLastName(this.LAST_NAMES[randomLastNameIndex]);
            newTraveller.setBudget(randomBudget);
            newTravellers.add(newTraveller);
        }
        return newTravellers;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(this.lastName);
        sb.append(" con ");
        sb.append(this.budget);
        sb.append(" de dinero para ir de ");
        sb.append(this.travel);
        sb.append(" puede ir en '");
        sb.append(this.transportType);
        sb.append("'.");
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
