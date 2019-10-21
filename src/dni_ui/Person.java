package dni_ui;

import java.time.LocalDate;

public class Person {
    private String name;
    private String lastNames;
    private LocalDate birth;
    private String dni;
    private int numbreDni = 43208361;

    public Person(String name, String lastNames, LocalDate birth, int numberDNI) {
        this.name = name;
        this.lastNames = lastNames;
        this.birth = birth;
        setDNI(numberDNI);
    }

    public void setDNI(int reference) {
        String createDni = createDNI(reference);
        this.dni = createDni;
    }

    public String createDNI(int reference) {
        char[] indexLetter = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int position = reference % 23;
        char letter = indexLetter[position];

        return Integer.toString(reference) + Character.toString(letter);
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString(){
        return this.name + ' ' + this.lastNames + ' ' + this.birth + ' ' + this.dni;
    }

}
