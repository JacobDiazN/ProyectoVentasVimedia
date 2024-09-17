package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findOne(int id);
    boolean update(Role r);
    boolean create(Role r);
    boolean delete(int id);
}
