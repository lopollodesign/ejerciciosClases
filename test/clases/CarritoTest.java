package clases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CarritoTest {
    
    public CarritoTest() {
    }

    @Test
    public void testGetNumProductos() {
        System.out.println("getNumProductos");
        Carrito instance = new Carrito();
        int expResult = 0;
        int result = instance.getNumProductos();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrecioTotal() {
        System.out.println("getPrecioTotal");
        Carrito instance = new Carrito();
        float expResult = 0.0F;
        float result = instance.getPrecioTotal();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetPesoTotal() {
        System.out.println("getPesoTotal");
        Carrito instance = new Carrito();
        float expResult = 0.0F;
        float result = instance.getPesoTotal();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testAddProducto() {
        System.out.println("addProducto");
        Producto producto = null;
        Carrito instance = new Carrito();
        instance.addProducto(producto);
    }

    @Test
    public void testRemoveProducto() {
        System.out.println("removeProducto");
        Producto producto = null;
        Carrito instance = new Carrito();
        instance.removeProducto(producto);
    }
    
}
