package clases.trabajofinal;

public abstract class Service {

    // Datos del constructor
    private String name;
    private Destination destination;
    private String company;

    public Service(String name, Destination destination, String company) {
        this.name = name;
        this.destination = destination;
        this.company = company;
    }

}
