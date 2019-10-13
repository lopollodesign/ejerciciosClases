package clases;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaProducto extends JTable{
    
    public TablaProducto(ArrayList<Producto> productos){
        super();
        this.fillData(productos);
    }
    
    public void fillData(ArrayList<Producto> productos) {
        ArrayList columnas;
        ((DefaultTableModel)this.getModel()).addColumn("Nombre");
        ((DefaultTableModel)this.getModel()).addColumn("Precio");
        ((DefaultTableModel)this.getModel()).addColumn("Peso");
        ((DefaultTableModel)this.getModel()).addColumn("Peso");
        for (Producto producto : productos){
            columnas = new ArrayList<String>();
            columnas.add(producto.nombre);
            columnas.add(producto.precio);
            columnas.add(producto.peso);
            ((DefaultTableModel)this.getModel()).addRow(columnas.toArray());
        }
    }
}
