package models;

import java.io.*;
import java.util.Date;

public class Traveller implements Serializable {

    private String name;
    private String lastName;
    private Date birthday;

    public Traveller(String name, String lastName, Date birthday) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return this.name;
    }

    // Aqui suscribimos el metodo de equals() de la clase generica `Object` que es de java de forma generica
    @Override
    public boolean equals(Object obj) {
        // Si el `Object` que le pasamos es de tipo `Traveller` pasará el if()
        if (obj instanceof Traveller){


            // Creamos una variable de tipo `Traveller` pasando el objeto a este tipo de objeto
            Traveller objTraveller = (Traveller)obj;

            // Creamos el boolean con la condicion de que los nombres de los dos sean iguales, y no si son la misma instancia
            return this.name == objTraveller.name && this.lastName == objTraveller.lastName;
        }
        return false;
    }


}
