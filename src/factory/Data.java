package factory;


import models.*;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    public List<Traveller> getTravellers() {
        return travellers;
    }

    private List<Traveller> travellers = Arrays.asList(
            new Traveller("Vicenç", "Álvarez Garau"),
            new Traveller("Margalida", "Garau Mateu"),
            new Traveller("Teo", "Álvarez Espinosa"),
            new Traveller("Vicente", "Álvarez Espinosa"),
            new Traveller("Óscar", "Álvarez Espinosa"),
            new Traveller("Pep", "Álvarez Espinosa"),
            new Traveller("Javier", "Álvarez Espinosa"),
            new Traveller("Sebas", "Álvarez Espinosa"),
            new Traveller("Carmina", "Espinosa de Frutos"),
            new Traveller("Vicente", "Álvarez Prieto"),
            new Traveller("Marina", "Calvo Trujillo")
    );

    public List<TransportType> getTransportTypes() {
        return transportTypes;
    }

    private List<TransportType> transportTypes = Arrays.asList(
            new TransportType("Bike", 1f, 6f),
            new TransportType("Bus", 5f, 18f),
            new TransportType("Train", 20f, 10f),
            new TransportType("Boat", 80f, 14f),
            new TransportType("Air plane", 5000f, 60f)
    );

    public List<Destination> getDestinations() {
        return destinations;
    }

    private List<Destination> destinations = Arrays.asList(
            new Destination("Berlin", new Point(3, 33)),
            new Destination("Munich", new Point(6, 30)),
            new Destination("Paris", new Point(9, 27)),
            new Destination("Palma", new Point(12, 24)),
            new Destination("London", new Point(15, 21)),
            new Destination("Lyon", new Point(18, 18)),
            new Destination("Gijon", new Point(21, 15)),
            new Destination("Bogota", new Point(24, 12)),
            new Destination("Lima", new Point(27, 9)),
            new Destination("Hong Kong", new Point(30, 6)),
            new Destination("Madrid", new Point(33, 3)),
            new Destination("Manchester", new Point(36, 6)),
            new Destination("Luxemburgo", new Point(39, 9)),
            new Destination("Rabat", new Point(42, 12)),
            new Destination("Fez", new Point(45, 15)),
            new Destination("Dublín", new Point(48, 18)),
            new Destination("Tolousse", new Point(51, 21)),
            new Destination("Granada", new Point(54, 24)),
            new Destination("Santander", new Point(57, 27)),
            new Destination("Mahón", new Point(60, 30))
    );


    public List<Hotel> getHotels() {
        return createHotels();
    }

    private List<Hotel> createHotels() {
        List<Hotel> autoHotels = new ArrayList<Hotel>();
        for (Destination destination: this.destinations ) {
            autoHotels.add(new Hotel("Hotel Iberostar " + destination.getName(), destination));
            autoHotels.add(new Hotel("Meliá " + destination.getName(), destination));
            autoHotels.add(new Hotel("Barceló " + destination.getName(), destination));
        }
        return autoHotels;
    }

    public List<Activity> getActivities() {
        return createActivity();
    }

    private List<Activity> createActivity() {
        List<Activity> autoActivity = new ArrayList<Activity>();
        for (Destination destination: this.destinations ) {
            autoActivity.add(new Activity("Visita guiada por " + destination.getName(), destination));
            autoActivity.add(new Activity("Casco antigui de " + destination.getName(), destination));
            autoActivity.add(new Activity("Ruta de la cerveza en " + destination.getName(), destination));
        }
        return autoActivity;
    }
}
