package cl.negenko.Proyecto.Ventas.model.repository;

import cl.negenko.Proyecto.Ventas.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
