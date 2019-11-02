package models;

public abstract class Service {
    private String name;
    private Destination destination;

    public Service(String name, Destination destination) {
        this.name = name;
        this.destination = destination;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
