/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author lopollo
 */
public class Producto{
    public String nombre;
    public float precio;
    public float peso;
    private int cantidad = 1;
    
    public Producto( String nombre , float precio , float peso ) {
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
    }
    
    public void addCantidad(int cantidad) {
        this.cantidad += cantidad;
    }
    
    public void removeCantidad(int cantidad) {
        if (this.cantidad - cantidad >= 0) {
            this.cantidad -= cantidad;
        } else {
            System.out.println("No se puede tener menos de 0 " + this.nombre);
        }
    }
    
    public float calcularPrecio() {
        float contador = (float) 0.0;
        for( int x = 1 ; x <= this.cantidad ; x++ ){
            contador += this.precio;
        }
        return contador;
    }
    
    public float calcularPeso() {
        float contador = (float) 0.0;
        float indexPeso = this.peso;
        for( int x = 1 ; x <= this.cantidad ; x++){
            if ( x > 1 ){
                indexPeso = this.peso * 80 / 100;
            }
            contador += indexPeso;
        }
        return contador;
    }
}
