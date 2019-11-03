package models;

public class Activity extends Service {
    public Activity(String name, Destination destination) {
        super(name, destination);
    }

    @Override
    public float getPrice() {
        return 0;
    }

}
