package models;

public abstract class Service {
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
            return (this.name + this.destination).equals(objService.name + objService.destination);
        }
        return false;
    }
}
