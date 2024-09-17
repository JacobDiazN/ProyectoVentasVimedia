package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findOne(int id);
    boolean update(User u);
    boolean create(User u);
    boolean delete(int id);

}
