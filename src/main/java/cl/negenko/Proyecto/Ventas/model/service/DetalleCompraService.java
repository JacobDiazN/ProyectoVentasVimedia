package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.DetalleCompra;

import java.util.List;

public interface DetalleCompraService {
    List<DetalleCompra> findAll();
    DetalleCompra findOne(int id);
    DetalleCompra update(DetalleCompra detalleCompra);
    DetalleCompra create(DetalleCompra detalleCompra);
    boolean delete(int id);
}
