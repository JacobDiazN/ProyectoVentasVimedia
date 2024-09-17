package cl.negenko.Proyecto.Ventas.model.repository;

import cl.negenko.Proyecto.Ventas.model.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
}
