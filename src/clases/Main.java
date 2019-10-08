/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;


/**
 *
 * @author lopollo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        producto sushi = new producto( "sushi" , 12.6f , 0.5f );
        producto raviolli = new producto( "raviolli" , 2.8f , 0.34f );
        producto cuixot = new producto( "Cuixot Artesà" , 8.7f , 0.87f );
        
        Carrito miCarrito = new Carrito();
        
        sushi.addCantidad(4);
        System.out.println("Todos los sushis pesan " + sushi.calcularPeso());
        System.out.println("Todos los valen " + sushi.calcularPrecio());
        
        miCarrito.addProducto(sushi);
        miCarrito.addProducto(raviolli);
        miCarrito.addProducto(cuixot);
        
        int numProductos = miCarrito.getNumProductos();
        float precioProductos = miCarrito.getPrecioTotal();
        float pesoProductos = miCarrito.getPesoTotal();
        
        System.out.println("Tienes un total de " + numProductos);
        System.out.println("Precio total: " + precioProductos);
        System.out.println("Peso un total: " + pesoProductos);
    }
    
}
