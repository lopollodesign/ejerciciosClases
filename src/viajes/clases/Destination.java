package viajes.clases;

import java.awt.*;

public class Destination {
    private String name;
    private Point p1;

    public Destination(String name, Point p1){
        this.name = name;
        this.p1 = p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getP1() {
        return p1;
    }

    public String getName() {
        return name;
    }
}
