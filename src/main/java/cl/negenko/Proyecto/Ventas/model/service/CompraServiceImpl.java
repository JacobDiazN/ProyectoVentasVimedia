package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Compra;
import cl.negenko.Proyecto.Ventas.model.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {

    private final CompraRepository repository;

    public CompraServiceImpl(CompraRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Compra> findAll() {
        return repository.findAll();
    }

    @Override
    public Compra findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Compra update(Compra compra) {
        return repository.save(compra);
    }

    @Override
    public Compra create(Compra compra) {
        return repository.save(compra);
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
