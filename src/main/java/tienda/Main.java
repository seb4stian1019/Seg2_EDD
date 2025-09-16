package tienda;

import java.util.Set;
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PROCESAMIENTO DE PEDIDOS E-COMMERCE ===\n");
        
        SistemaDePedidos sistema = new SistemaDePedidos();
        System.out.println("Agregando productos al catálogo...");
        Producto producto1 = new Producto("TEC-001", "Teclado Mecánico RGB", 189900.00);
        Producto producto2 = new Producto("MON-002", "Monitor 24\" 4K", 899900.00);
        Producto producto3 = new Producto("RAT-003", "Ratón Inalámbrico Gaming", 129900.00);
        Producto producto4 = new Producto("AUD-004", "Auriculares Bluetooth", 179900.00);
        
        sistema.agregarProductoAlCatalogo(producto1);
        sistema.agregarProductoAlCatalogo(producto2);
        sistema.agregarProductoAlCatalogo(producto3);
        sistema.agregarProductoAlCatalogo(producto4);
        
        System.out.println("Productos agregados al catálogo: " + sistema.getNumeroProductos());
        
        System.out.println("\nCreando órdenes...");
        Orden orden1 = new Orden(101);
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        
        Orden orden2 = new Orden(102);
        orden2.agregarProducto(producto1);
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto1);
        orden2.agregarProducto(producto4);
        
        Orden orden3 = new Orden(103);
        orden3.agregarProducto(producto2);
        orden3.agregarProducto(producto2);
        orden3.agregarProducto(producto3);
        
        sistema.registrarOrden(orden1);
        sistema.registrarOrden(orden2);
        sistema.registrarOrden(orden3);
        
        System.out.println("Órdenes registradas: " + sistema.getNumeroOrdenesPendientes());
        
        SistemaDePedidos.imprimirColeccion("Estado de la Cola de Pedidos", 
                                         sistema.getColaDePedidos());
        
        System.out.println("=== PROCESANDO ÓRDENES ===");
        while (!sistema.estaColaVacia()) {
            Orden ordenProcesada = sistema.procesarSiguienteOrden();
            if (ordenProcesada != null) {
                System.out.println("Detalles de la orden procesada:");
                System.out.println("  - ID: " + ordenProcesada.getId());
                System.out.println("  - Total: $" + ordenProcesada.calcularTotal());
                System.out.println("  - Número de productos: " + ordenProcesada.getProductos().size());
                System.out.println();
            }
        }
        
        System.out.println("Intentando procesar otra orden...");
        sistema.procesarSiguienteOrden(); // Debe mostrar que la cola está vacía
        
        System.out.println("=== DEMOSTRACIÓN DE PRODUCTOS ÚNICOS ===");
        Orden ordenDemo = new Orden(999);
        ordenDemo.agregarProducto(producto1);
        ordenDemo.agregarProducto(producto2);
        ordenDemo.agregarProducto(producto1);
        ordenDemo.agregarProducto(producto3);
        ordenDemo.agregarProducto(producto2);
        ordenDemo.agregarProducto(producto1);
        
        System.out.println("Orden de demostración:");
        System.out.println("Total de productos: " + ordenDemo.getProductos().size());
        System.out.println("Total: $" + ordenDemo.calcularTotal());
        
        System.out.println("\nProductos únicos en la orden:");
        Set<Producto> productosUnicos = ordenDemo.obtenerProductosUnicos();
        SistemaDePedidos.imprimirColeccion("Productos Únicos", productosUnicos);
        
        System.out.println("Número de productos únicos: " + productosUnicos.size());
        
        System.out.println("=== DEMOSTRACIÓN DE BÚSQUEDA DE PRODUCTOS ===");
        Producto productoEncontrado = sistema.buscarProducto("TEC-001");
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado);
        } else {
            System.out.println("Producto no encontrado");
        }
        
        SistemaDePedidos.imprimirColeccion("Catálogo Completo de Productos", 
                                         sistema.getCatalogoProductos().values());
        
        System.out.println("=== SIMULACIÓN COMPLETADA ===");
    }
}
