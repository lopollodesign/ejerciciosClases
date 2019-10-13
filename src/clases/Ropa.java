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
public class Ropa extends Producto{
    private String color;
    private String talla;
    private String material;
    private String prenda;

    public Ropa(String color, String talla, String material, String prenda, float precio){
        super(prenda, precio, 0.0f);
        this.color = color;
        this.talla = talla;
        this.material = material;
        this.prenda = prenda;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    public String getColor() {
        return color;
    }

    public String getTalla() {
        return talla;
    }

    public String getMaterial() {
        return material;
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }
    
}
