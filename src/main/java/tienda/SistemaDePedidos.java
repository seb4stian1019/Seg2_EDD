package tienda;

import java.util.*;
public class SistemaDePedidos {
    // DECISIÓN DE DISEÑO: HashMap para catálogo de productos
    // Justificación: HashMap ofrece búsqueda O(1) por SKU, que es la operación
    // más frecuente. El SKU es único y perfecto como clave para acceso eficiente.
    private Map<String, Producto> catalogoProductos;
    
    // DECISIÓN DE DISEÑO: LinkedList implementando Queue para cola de pedidos
    // Justificación: LinkedList garantiza el orden FIFO (First-In, First-Out)
    // y ofrece operaciones O(1) para agregar al final y extraer del inicio,
    // que es exactamente lo que necesitamos para procesar pedidos en orden.
    private Queue<Orden> colaDePedidos;
    
    public SistemaDePedidos() {
        this.catalogoProductos = new HashMap<>();
        this.colaDePedidos = new LinkedList<>();
    }
    
    public void agregarProductoAlCatalogo(Producto producto) {
        if (producto != null && producto.getSku() != null) {
            catalogoProductos.put(producto.getSku(), producto);
        }
    }
    
    public Producto buscarProducto(String sku) {
        return catalogoProductos.get(sku);
    }
    
    public void registrarOrden(Orden orden) {
        if (orden != null) {
            colaDePedidos.offer(orden);
        }
    }
    
    public Orden procesarSiguienteOrden() {
        if (colaDePedidos.isEmpty()) {
            System.out.println("La cola de pedidos está vacía.");
            return null;
        }
        
        Orden orden = colaDePedidos.poll();
        System.out.println("Procesando Orden #" + orden.getId() + " con un total de $" + orden.calcularTotal());
        return orden;
    }

    public static <T> void imprimirColeccion(String titulo, Collection<T> coleccion) {
        System.out.println("\n=== " + titulo + " ===");
        if (coleccion.isEmpty()) {
            System.out.println("La colección está vacía.");
        } else {
            int contador = 1;
            for (T elemento : coleccion) {
                System.out.println(contador + ". " + elemento);
                contador++;
            }
        }
        System.out.println();
    }
    
    public Map<String, Producto> getCatalogoProductos() {
        return new HashMap<>(catalogoProductos);
    }
    
    public Queue<Orden> getColaDePedidos() {
        return new LinkedList<>(colaDePedidos);
    }

    public boolean estaColaVacia() {
        return colaDePedidos.isEmpty();
    }

    public int getNumeroProductos() {
        return catalogoProductos.size();
    }

    public int getNumeroOrdenesPendientes() {
        return colaDePedidos.size();
    }
}
