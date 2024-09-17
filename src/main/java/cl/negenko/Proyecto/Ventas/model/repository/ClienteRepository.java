package cl.negenko.Proyecto.Ventas.model.repository;

import cl.negenko.Proyecto.Ventas.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
