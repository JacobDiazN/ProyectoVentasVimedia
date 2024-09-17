package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Direccion;

import java.util.List;

public interface DireccionService {
    List<Direccion> findAll();
    Direccion findOne(int id);
    Direccion update(Direccion direccion);
    Direccion create(Direccion direccion);
    boolean delete(int id);
}
