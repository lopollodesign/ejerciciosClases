package models;

import java.util.Random;

public abstract class Service {
    private String name;
    public Destination destination;
    private float price;

    public Service(String name, Destination destination) {
        this.name = name;
        this.destination = destination;
        Random random = new Random();
        this.price = random.nextFloat() * 100;
    }

    @Override
    public String toString(){
        return this.name;
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

    public float getPrice() {
        return this.price;
    }

    public boolean isHotel(){
        return this instanceof Hotel;
    }
}
