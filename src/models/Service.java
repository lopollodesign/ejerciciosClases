package models;

public abstract class Service implements Bookable {
    private String name;
    public Destination destination;

    public Service(String name, Destination destination) {
        this.name = name;
        this.destination = destination;
    }

    @Override
    public String toString(){
        return this.name + ". Destination: " + this.destination;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Service){
            Service objService = (Service) obj;
            // De dejo el equals del mismo Destination
            // Si mas adelante se quisiera comparar de una forma mas concreta el Destino no me afectaria aqui.
            return (this.name).equals(objService.name) && this.destination.equals(objService.destination);
        }
        return false;
    }
}
