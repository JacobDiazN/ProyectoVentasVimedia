package cl.negenko.Proyecto.Ventas.model.repository;

import cl.negenko.Proyecto.Ventas.model.entities.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer> {
}
