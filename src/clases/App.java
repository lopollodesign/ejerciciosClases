package clases;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class App extends JFrame{
   public String nombre;
   private ArrayList<Producto> productos = new ArrayList();
    
   public App ( String nombre , ArrayList<Producto> productos) {
      this.nombre = nombre;
      this.initJFrame(productos);
   }
   
   private void initJFrame(ArrayList<Producto> productos) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle(this.nombre);
        JPanel panel = new JPanel(new CardLayout());
        panel.add(new TablaProducto(productos));
        this.add(panel);
    }
}
