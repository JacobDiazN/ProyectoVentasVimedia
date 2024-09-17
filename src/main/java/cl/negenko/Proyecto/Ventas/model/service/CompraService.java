package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Compra;

import java.util.List;

public interface CompraService {
    List<Compra> findAll();
    Compra findOne(int id);
    Compra update(Compra compra);
    Compra create(Compra compra);
    boolean delete(int id);
}
