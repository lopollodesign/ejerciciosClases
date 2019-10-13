package clases;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaProducto extends JTable {
    
    public TablaProducto(ArrayList<Producto> productos){
        super();
        this.fillData(productos);
    }
    
    public void fillData(ArrayList<Producto> productos) {
        ((DefaultTableModel)this.getModel()).addColumn("Nombre");
        ((DefaultTableModel)this.getModel()).addColumn("Precio");
        ((DefaultTableModel)this.getModel()).addColumn("Peso");

        ArrayList headerGeneral = new ArrayList<String>();
        headerGeneral.add("Nombre");
        headerGeneral.add("Precio");
        headerGeneral.add("Peso");

        ArrayList headerSeparate = new ArrayList<String>();
        headerSeparate.add(" ");

        ArrayList headerStock = new ArrayList<String>();
        headerStock.add("STOCK");

        ((DefaultTableModel)this.getModel()).addRow(headerStock.toArray());
        ((DefaultTableModel)this.getModel()).addRow(headerGeneral.toArray());

        ArrayList columnasStock;
        for (Producto producto : productos){
            columnasStock = new ArrayList<String>();
            columnasStock.add(producto.getNombre());
            columnasStock.add(producto.getPrecio());
            columnasStock.add(producto.getPeso());
            ((DefaultTableModel)this.getModel()).addRow(columnasStock.toArray());
        }

        ArrayList headerCarrito = new ArrayList<String>();
        headerCarrito.add("CARRITO");

        ((DefaultTableModel)this.getModel()).addRow(headerSeparate.toArray());
        ((DefaultTableModel)this.getModel()).addRow(headerCarrito.toArray());
        ((DefaultTableModel)this.getModel()).addRow(headerGeneral.toArray());
    }
}
