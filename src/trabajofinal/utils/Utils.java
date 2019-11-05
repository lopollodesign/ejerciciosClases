package trabajofinal.utils;

import java.text.DecimalFormat;

public class Utils {

    public static String prettyPrice(float price){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(price) + " €";
    }

}
