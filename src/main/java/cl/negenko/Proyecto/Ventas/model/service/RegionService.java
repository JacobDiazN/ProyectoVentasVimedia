package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Region;

import java.util.List;

public interface RegionService {
    List<Region> findAll();
    Region findOne(int id);
    Region update(Region region);
    Region create(Region region);
    boolean delete(int id);
}
