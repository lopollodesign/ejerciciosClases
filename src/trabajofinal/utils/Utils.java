package trabajofinal.utils;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Utils {

    public static String prettyPrice(float price){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(price) + " €";
    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
