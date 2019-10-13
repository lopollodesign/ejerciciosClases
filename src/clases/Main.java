package clases;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto sushi = new Producto( "sushi" , 12.6f , 0.5f );
        Producto raviolli = new Producto( "raviolli" , 2.8f , 0.34f );
        Producto cuixot = new Producto( "Cuixot Artesà" , 8.7f , 0.87f );
        Producto pantalon = new Ropa("Verde", "XL", "Seda", "Pantalón", 5f);
        Carrito miCarrito = new Carrito();
        sushi.addCantidad(4);
        System.out.println("Todos los sushis pesan " + sushi.calcularPeso());
        System.out.println("Todos los valen " + sushi.calcularPrecio());
        miCarrito.addProducto(sushi);
        miCarrito.addProducto(raviolli);
        miCarrito.addProducto(cuixot);
        miCarrito.addProducto(pantalon);
        int numProductos = miCarrito.getNumProductos();
        float precioProductos = miCarrito.getPrecioTotal();
        float pesoProductos = miCarrito.getPesoTotal();
        System.out.println("Tienes un total de " + numProductos);
        System.out.println("Precio total: " + precioProductos);
        System.out.println("Peso un total: " + pesoProductos);
        System.out.println(pantalon);
        
        
        
        App app = new App("Mi aplicación", miCarrito.getProductos());
        app.setVisible(true);
    }
    
}
