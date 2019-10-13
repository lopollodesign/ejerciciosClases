package clases;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Producto generico = new Producto( "NOMBRE" , 0000f , 0000f );
        Producto sushi = new Producto( "sushi" , 12.6f , 0.5f );
        Producto raviolli = new Producto( "raviolli" , 2.8f , 0.34f );
        Producto cuixot = new Producto( "Cuixot Artesà" , 8.7f , 0.87f );
        Producto pantalon = new Ropa("Verde", "XL", "Seda", "Pantalón", 5f);

        Stock Stock = new Stock();
        Stock.addProducto(generico);
        Stock.addProducto(sushi);
        Stock.addProducto(raviolli);
        Stock.addProducto(cuixot);
        Stock.addProducto(pantalon);

        int numProductos = Stock.getNumProductos();
        float precioProductos = Stock.getPrecioTotal();
        float pesoProductos = Stock.getPesoTotal();

        System.out.println("Tienes un total de " + numProductos);
        System.out.println("Precio total: " + precioProductos);
        System.out.println("Peso un total: " + pesoProductos);
        System.out.println(pantalon);
        

        App app = new App("Mi aplicación", Stock.getProductos());
        app.setVisible(true);
    }
    
}
