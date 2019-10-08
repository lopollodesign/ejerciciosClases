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
public class Carrito {
    private ArrayList<producto> productos = new ArrayList(); 
    
    public Carrito(){       
    }
    
    public int getNumProductos(){
        return productos.size();
    }
    
    public float getPrecioTotal(){
        float contador = (float) 0.0;
        for( producto index : productos) {
            contador += index.precio;
        }
        return contador;
    }
    
    public float getPesoTotal(){
        float contador = (float) 0.0;
        for( producto index : productos) {
            contador += index.peso;
        }
        return contador;
    }
    
    public void addProducto(producto producto){
        this.productos.add(producto);
    }
    
    public void removeProducto(producto producto){
        this.productos.remove(producto);
    }
    
}
