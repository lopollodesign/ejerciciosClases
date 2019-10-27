package clases.trabajofinal;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Destination {
    private String name;
    private Point point;

    private String[] NAMES = {"Berlín", "Munich", "París", "Barcelona", "Lyon", "Madrid", "Gijón", "Palma de Mallorca", "Tenerife", "Bogotá", "Lima", "Hong Kong"};
    private Point[] POINTS = { new Point(3 ,4 ) , new Point(6 ,9 ), new Point(10 ,2 ), new Point(20 ,10 ), new Point(50 ,30 ) };

    public Destination(){}

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance( Destination arrival ){
        int departureX = this.point.x;
        int departureY = this.point.y;
        int arrivalX = arrival.point.x;
        int arrivalY = arrival.point.y;
        double distance = Math.sqrt((Math.pow( (arrivalX - departureX) , 2)) + (Math.pow( (arrivalY - departureY) , 2)));

        return 5f * (float) distance;
    }

    List<Destination> createDestinations() {
        List<Destination> newDestinations = new ArrayList<>();
        Random random = new Random();
        for (String name : this.NAMES) {
            Destination newDestination = new Destination();
            newDestination.setName(name);
            int randomPointsIndex = random.nextInt(this.POINTS.length);
            newDestination.setPoint(this.POINTS[randomPointsIndex]);
            newDestinations.add(newDestination);
        }
        return newDestinations;

    }

    @Override
    public String toString(){
        return this.name + ". X > " + this.point.x + ", Y > " + this.point.y;
    }
}
