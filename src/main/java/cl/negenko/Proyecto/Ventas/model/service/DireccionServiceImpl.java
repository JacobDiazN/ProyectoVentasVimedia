package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Direccion;
import cl.negenko.Proyecto.Ventas.model.repository.DireccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionServiceImpl(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    @Override
    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    @Override
    public Direccion findOne(int id) {
        return direccionRepository.findById(id).orElse(null);
    }

    @Override
    public Direccion update(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public Direccion create(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public boolean delete(int id) {
        boolean exist = direccionRepository.existsById(id);
        if(exist){
            direccionRepository.deleteById(id);
        }
        return exist;
    }
}
