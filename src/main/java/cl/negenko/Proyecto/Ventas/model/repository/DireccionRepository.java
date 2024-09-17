package cl.negenko.Proyecto.Ventas.model.repository;

import cl.negenko.Proyecto.Ventas.model.entities.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
}
