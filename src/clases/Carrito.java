package clases;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Producto> productos = new ArrayList(); 

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public Carrito(){}
    
    public int getNumProductos(){
        return productos.size();
    }
    
    public float getPrecioTotal(){
        float contador = (float) 0.0;
        for( Producto index : productos) {
            contador += index.precio;
        }
        return contador;
    }
    
    public float getPesoTotal(){
        float contador = (float) 0.0;
        for( Producto index : productos) {
            contador += index.peso;
        }
        return contador;
    }
    
    public void addProducto(Producto producto){
        this.productos.add(producto);
    }
    
    public void removeProducto(Producto producto){
        this.productos.remove(producto);
    }
    
}
