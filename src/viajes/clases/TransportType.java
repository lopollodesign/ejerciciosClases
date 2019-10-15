package viajes.clases;

public class TransportType {
    private  String name;
    private float price;
    private int speed;

    public TransportType(String name, float price, int speed){
        this.name = name;
        this.price = price;
        this.speed = speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }
}
