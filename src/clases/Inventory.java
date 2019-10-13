package clases;

import java.util.ArrayList;

public class Inventory {
    protected ArrayList<Producto> productos;

    public Inventory(ArrayList<Producto> productos){
        this.productos = productos;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public int getNumProductos(){
        return productos.size();
    }

    public float sumPrice(){
        float accountant = (float) 0.0;
        for( Producto index : productos) {
            accountant += index.getPrecio();
        }
        return accountant;
    }

    public float sumPeso(){
        float accountant = (float) 0.0;
        for( Producto index : productos) {
            accountant += index.getPeso();
        }
        return accountant;
    }

    public void addProducto(Producto producto){
        this.productos.add(producto);
    }

    public void removeProduct(Producto producto){
        this.productos.remove(producto);
    }
}
