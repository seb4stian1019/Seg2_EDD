# Sistema de Procesamiento de Pedidos E-Commerce

## Descripción
Sistema robusto para gestionar un catálogo de productos y procesar pedidos en línea, implementado usando Java Collections Framework y Genéricos.

## Estructura del Proyecto

### Clases Principales

1. **Producto.java**
   - Representa un artículo en el catálogo
   - Atributos: sku, nombre, precio
   - Implementa contrato equals()/hashCode() basado en SKU

2. **Orden.java**
   - Representa un pedido de cliente
   - Atributos: id, productos (ArrayList)
   - Métodos: agregarProducto(), calcularTotal(), obtenerProductosUnicos()

3. **SistemaDePedidos.java**
   - Clase central del sistema
   - Catálogo: HashMap<String, Producto> (búsqueda O(1) por SKU)
   - Cola: LinkedList<Orden> (procesamiento FIFO)
   - Método genérico: imprimirColeccion()

4. **Main.java**
   - Simulación completa del sistema
   - Demuestra todas las funcionalidades

## Decisiones de Diseño

### Catálogo de Productos
- **Estructura**: HashMap<String, Producto>
- **Justificación**: Búsqueda O(1) por SKU, que es la operación más frecuente

### Cola de Pedidos
- **Estructura**: LinkedList<Orden> implementando Queue
- **Justificación**: Garantiza orden FIFO con operaciones O(1)

### Productos en Orden
- **Estructura**: ArrayList<Producto>
- **Justificación**: Permite duplicados y mantiene orden de inserción

## Funcionalidades Implementadas

- ✅ Gestión de catálogo de productos
- ✅ Procesamiento de órdenes en orden FIFO
- ✅ Búsqueda eficiente de productos por SKU
- ✅ Cálculo de totales de órdenes
- ✅ Eliminación de duplicados en productos únicos
- ✅ Método genérico para reportes
- ✅ Simulación completa del sistema

## Compilación y Ejecución

```bash
# Compilar
javac -source 8 -target 8 *.java

# Ejecutar
java Main
```

## Características Técnicas

- **Genéricos**: Implementados para seguridad de tipos
- **Collections Framework**: Uso optimizado de List, Set, Map, Queue
- **Contrato equals/hashCode**: Implementado correctamente en Producto
- **Principio DRY**: Método genérico para reportes
- **Encapsulación**: Getters que retornan copias defensivas

## Autor
Sistema implementado para el curso de Estructura de Datos

