package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.TipoVivienda;
import cl.negenko.Proyecto.Ventas.model.repository.TipoViviendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoViviendaServiceImpl implements TipoViviendaService {

    private final TipoViviendaRepository repository;

    public TipoViviendaServiceImpl(TipoViviendaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoVivienda> findAll() {
        return repository.findAll();
    }

    @Override
    public TipoVivienda findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TipoVivienda update(TipoVivienda tipoVivienda) {
        return repository.save(tipoVivienda);
    }

    @Override
    public TipoVivienda create(TipoVivienda tipoVivienda) {
        return repository.save(tipoVivienda);
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
