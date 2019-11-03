package models;

import java.io.Serializable;

public class Traveller implements Serializable {

    private String name;
    private String lastName;

    public Traveller(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.name + " " + this.lastName;
    }
}
