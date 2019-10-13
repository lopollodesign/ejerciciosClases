package clases;

import java.util.ArrayList;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Producto sushi = new Producto( "Sushi" , 12.6f , 0.5f );
        Producto raviolli = new Producto( "Raviolli" , 2.8f , 0.34f );
        Producto cuixot = new Producto( "Cuixot Artesà" , 8.7f , 0.87f );
        Producto pantalon = new Ropa("Verde", "XL", "Seda", "Pantalón", 5f);

        Stock Stock = new Stock(new ArrayList<>());
        Stock.addProducto(sushi);
        Stock.addProducto(raviolli);
        Stock.addProducto(cuixot);
        Stock.addProducto(pantalon);

        App app = new App("Mi aplicación", Stock.getProductos());
        app.setVisible(true);
    }
    
}
