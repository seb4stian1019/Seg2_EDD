package tienda;

import java.util.*;
// DECISIÓN DE DISEÑO: ArrayList para almacenar productos en la orden
// Justificación: permite duplicados y agrega en O(1) amortizado; el orden de
// inserción no es relevante para el negocio, pero la lista facilita acumulación.
public class Orden {
    private int id;
    private List<Producto> productos;
    
    public Orden(int id) {
        this.id = id;
        this.productos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }
    
    public double calcularTotal() {
        return productos.stream()
                       .mapToDouble(Producto::getPrecio)
                       .sum();
    }
    
    public Set<Producto> obtenerProductosUnicos() {
        return new HashSet<>(productos);
    }
    
    public int getId() {
        return id;
    }
    
    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    @Override
    public String toString() {
        return "Orden #" + id + " - Total: $" + calcularTotal() + " - Productos: " + productos.size();
    }
}

