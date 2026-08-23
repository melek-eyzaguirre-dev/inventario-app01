package ymdev.inventarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ymdev.inventarios.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    // JpaRepository ya incluye los métodos necesarios.
    // Puedes agregar consultas personalizadas aquí si las necesitas en el futuro.
}