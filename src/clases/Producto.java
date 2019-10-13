package clases;

public class Producto{
    private String nombre;
    private float precio;
    private float peso;
    private int cantidad = 1;

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public float getPeso() {
        return peso;
    }

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
