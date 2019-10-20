package viajes.clases;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Destination {
    private String name;
    private Point point;

    private String[] NAMES = {"Badajoz", "Santoña", "Puyo", "Minca", "San Pedro", "Valldemossa", "Béjar"};
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

        return 20f * (float) distance;
    }

    public List<Destination> createDestinations(){
        List<Destination> newDestinations = new ArrayList<>();
        Random random = new Random();
        for( int i = 0 ; i < this.NAMES.length ; ++i ){
            Destination newDestination = new Destination();
            newDestination.setName(this.NAMES[i]);
            int randomPointsIndex = random.nextInt(this.POINTS.length);
            newDestination.setPoint(this.POINTS[randomPointsIndex]);
            newDestinations.add(newDestination);
        }
        return newDestinations;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
