package clases;

import java.util.ArrayList;

public class Stock {

    private ArrayList<Producto> productos = new ArrayList<>();

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public Stock(){}
    
    public int getNumProductos(){
        return productos.size();
    }
    
    public float getPrecioTotal(){
        float contador = (float) 0.0;
        for( Producto index : productos) {
            contador += index.getPrecio();
        }
        return contador;
    }
    
    public float getPesoTotal(){
        float contador = (float) 0.0;
        for( Producto index : productos) {
            contador += index.getPeso();
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
