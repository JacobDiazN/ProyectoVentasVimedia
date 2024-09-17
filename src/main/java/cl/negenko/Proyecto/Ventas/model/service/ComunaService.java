package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Comuna;

import java.util.List;

public interface ComunaService {
    List<Comuna> findAll();
    Comuna findOne(int id);
    Comuna update(Comuna comuna);
    Comuna create(Comuna comuna);
    boolean delete(int id);
}
