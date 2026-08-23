package ymdev.inventarios.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ymdev.inventarios.modelo.Producto;
import ymdev.inventarios.servicio.IProductoServicio;

import java.util.List;

@RestController
@RequestMapping("inventario-app") // http://localhost:8080/inventario-app
@CrossOrigin(origins = "http://localhost:4200") // Permite conexión desde Angular
public class ProductoControlador {

    private final IProductoServicio productoServicio;

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    public ProductoControlador(IProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    // Listar todos los productos
    // http://localhost:8080/inventario-app/productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        List<Producto> productos = productoServicio.listarProductos();
        logger.info("Productos obtenidos: ");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    // Buscar producto por id
    // http://localhost:8080/inventario-app/productos/{id}
    @GetMapping("/productos/{id}")
    public Producto buscarProductoPorId(@PathVariable Integer id) {
        Producto producto = productoServicio.buscarProductoPorId(id);
        logger.info("Producto encontrado: " + producto);
        return producto;
    }

    // Crear un nuevo producto
    // http://localhost:8080/inventario-app/productos
    @PostMapping("/productos")
    public Producto guardarProducto(@RequestBody Producto producto) {
        logger.info("Producto a agregar: " + producto);
        return productoServicio.guardarProducto(producto);
    }

    // Actualizar un producto existente
    // http://localhost:8080/inventario-app/productos/{id}
    @PutMapping("/productos/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setIdProducto(id);
        logger.info("Producto a actualizar: " + producto);
        return productoServicio.guardarProducto(producto);
    }

    // Eliminar producto por id
    // http://localhost:8080/inventario-app/productos/{id}
    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        logger.info("Id producto a eliminar: " + id);
        productoServicio.eliminarProductoPorId(id);
    }
}