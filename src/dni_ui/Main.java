package dni_ui;

public class Main {

    public static void main(String[] args) {
        char[] indexLetter = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        String[][] cartera = { {"Vicens","Marina","Mama","Papa"} , {"43208361","43217190","42998922","43012034"} };

        int number = 43208361;
        int marinaNumber = 43217190;
        int mamaNumber = 42998922;
        int papaNumber = 43012034;

        System.out.println(complete(number, false));
        System.out.println(complete(marinaNumber, false));
        System.out.println(complete(mamaNumber, false));
        System.out.println(complete(papaNumber, false));

        System.out.println("");
        System.out.println("Con el for desde el Array:");
        for ( int index = 0 ; index < cartera[0].length ; ++index ){
            String name = cartera[0][index];

            String nameNumber = cartera[1][index];
            int simpleNumber = Integer.parseInt(nameNumber);
            String completeDNI = complete(simpleNumber, true);

            // DUDA:
            // String otherPrint = complete(Integer.parseInt(cartera[1][index]),true);

            System.out.println("El DNI de " + name + " es " + completeDNI);
        }
    }

    public static String complete(int reference , boolean simple) {
        char[] indexLetter = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int position = reference % 23;
        char letter = indexLetter[position];

        if (simple){
            return Integer.toString(reference) + Character.toString(letter);
        } else {
            if ( reference == 0 ) {
                return "No puede ser 0";
            }
            return "El DNI completo es: " + Integer.toString(reference) + Character.toString(letter);
        }
    }

}
