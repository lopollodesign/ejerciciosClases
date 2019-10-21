package dni_ui;

import java.time.LocalDate;
import java.util.*;
import dni_ui.Person;

public class Main {

    public static void main(String[] args) {

        Person antonio = new Person("Antonio", "Gonzalez", LocalDate.of(1991, 6, 30), 43208361);
        Person maria = new Person("Maria", "Gonzalez", LocalDate.of(1994, 7, 20), 30203061);

        HashMap<String, Person> map = new HashMap <String, Person> ();
        map.put(antonio.getDni(), antonio);
        map.put(maria.getDni(), maria);

        String inputDni;
        do {
            System.out.println("Pon un numero de DNI (incluida la letra)");
            Scanner scanner = new Scanner(System.in);
            inputDni = scanner.nextLine();

            if (map.containsKey(inputDni)){
                String person = map.get(inputDni).toString();
                System.out.println("Existe, es " + person);
            } else {
                System.out.println("No existe Existe");
            }
        } while (inputDni == "exit" || !map.containsKey(inputDni));

    }


}
