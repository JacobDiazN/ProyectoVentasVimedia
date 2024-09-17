package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Region;
import cl.negenko.Proyecto.Ventas.model.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository repository;

    public RegionServiceImpl(RegionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Region> findAll() {
        return repository.findAll();
    }

    @Override
    public Region findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Region update(Region region) {
        return repository.save(region);
    }

    @Override
    public Region create(Region region) {
        return repository.save(region);
    }

    @Override
    public boolean delete(int id) {
        boolean exist = repository.existsById(id);
        if(exist){
            repository.deleteById(id);
        }
        return exist;
    }
}
