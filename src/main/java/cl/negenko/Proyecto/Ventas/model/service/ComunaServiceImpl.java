package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Comuna;
import cl.negenko.Proyecto.Ventas.model.repository.ComunaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunaServiceImpl implements ComunaService {

    private final ComunaRepository comunaRepository;

    public ComunaServiceImpl(ComunaRepository comunaRepository) {
        this.comunaRepository = comunaRepository;
    }

    @Override
    public List<Comuna> findAll() {
        return comunaRepository.findAll();
    }

    @Override
    public Comuna findOne(int id) {
        return comunaRepository.findById(id).orElse(null);
    }

    @Override
    public Comuna update(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    @Override
    public Comuna create(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    @Override
    public boolean delete(int id) {
        boolean exist = comunaRepository.existsById(id);
        if(exist){
            comunaRepository.deleteById(id);
        }
        return exist;
    }
}
