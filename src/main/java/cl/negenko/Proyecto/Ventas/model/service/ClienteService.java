package cl.negenko.Proyecto.Ventas.model.service;


import cl.negenko.Proyecto.Ventas.model.entities.Cliente;
import cl.negenko.Proyecto.Ventas.model.entities.Direccion;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findOne(int id);
    Cliente update(int id, Cliente clienteActualizado, Direccion direccionActualizada, int idComuna, int idTipoVivienda, int idRegion);
    Cliente create(Cliente cliente, int idComuna, int idTipoVivienda, int idRegion, Direccion direccion);
    boolean delete(int id);
}
