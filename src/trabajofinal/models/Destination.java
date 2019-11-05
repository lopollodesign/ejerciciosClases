package trabajofinal.models;

import java.awt.Point;

public class Destination {
    private String name;
    private Point point;

    public Destination(String name, Point point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public float getDistance(Destination arrival ){
        int departureX = this.point.x;
        int departureY = this.point.y;
        int arrivalX = arrival.point.x;
        int arrivalY = arrival.point.y;
        double distance = Math.sqrt((Math.pow( (arrivalX - departureX) , 2)) + (Math.pow( (arrivalY - departureY) , 2)));

        return 5f * (float) distance;
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Destination){
            Destination objDestination = (Destination) obj;
            return this.name.equals(objDestination.name);
        }
        return false;
    }
}
