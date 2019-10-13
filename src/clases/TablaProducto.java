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
        ArrayList columnas;
        ((DefaultTableModel)this.getModel()).addColumn("Nombre");
        ((DefaultTableModel)this.getModel()).addColumn("Precio");
        ((DefaultTableModel)this.getModel()).addColumn("Peso");

        ArrayList header = new ArrayList<String>();
        header.add("Nombre");
        header.add("Precio");
        header.add("Peso");
        ((DefaultTableModel)this.getModel()).addRow(header.toArray());

        for (Producto producto : productos){
            columnas = new ArrayList<String>();
            columnas.add(producto.getNombre());
            columnas.add(producto.getPrecio());
            columnas.add(producto.getPeso());
            ((DefaultTableModel)this.getModel()).addRow(columnas.toArray());
        }
    }
}
