package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Producto;

import java.util.List;

public interface ProductoService{
    List<Producto> findAll();
    Producto findOne(int id);
    Producto update(int id, Producto productoActualizado);
    Producto create(Producto producto);
    boolean delete(int id);
}
