package clases;

public class Producto{
    private String nombre;
    private float precio;
    private float peso;
    private int units = 1;

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
    
    public void addUnity(int quantity) {
        this.units += quantity;
    }
    
    public void removeUnity(int quantity) {
        if (this.units - quantity >= 0) {
            this.units -= quantity;
        } else {
            System.out.println("No se puede tener menos de 0 " + this.nombre);
        }
    }
    
    public float sumPrice() {
        float accountant = (float) 0.0;
        for( int x = 1 ; x <= this.units ; x++ ){
            accountant += this.precio;
        }
        return accountant;
    }
    
    public float sumPeso() {
        float accountant = (float) 0.0;
        float indexPeso = this.peso;
        for( int x = 1 ; x <= this.units ; x++){
            if ( x > 1 ){
                indexPeso = this.peso * 80 / 100;
            }
            accountant += indexPeso;
        }
        return accountant;
    }
}
