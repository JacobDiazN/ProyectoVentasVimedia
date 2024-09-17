package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.DetalleCompra;
import cl.negenko.Proyecto.Ventas.model.repository.DetalleCompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {


    private final DetalleCompraRepository repository;

    public DetalleCompraServiceImpl(DetalleCompraRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DetalleCompra> findAll() {
        return repository.findAll();
    }

    @Override
    public DetalleCompra findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DetalleCompra update(DetalleCompra detalleCompra) {
        return repository.save(detalleCompra);
    }

    @Override
    public DetalleCompra create(DetalleCompra detalleCompra) {
        return repository.save(detalleCompra);
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
