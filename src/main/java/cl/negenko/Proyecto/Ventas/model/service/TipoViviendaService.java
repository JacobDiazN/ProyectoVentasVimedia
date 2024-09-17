package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.TipoVivienda;

import java.util.List;

public interface TipoViviendaService {
    List<TipoVivienda> findAll();
    TipoVivienda findOne(int id);
    TipoVivienda update(TipoVivienda tipoVivienda);
    TipoVivienda create(TipoVivienda tipoVivienda);
    boolean delete(int id);
}
