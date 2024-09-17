package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Role;
import cl.negenko.Proyecto.Ventas.model.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Role r) {
        Role result = repository.save(r);
        return true;
    }

    @Override
    public boolean create(Role r) {
        repository.save(r);
        return true;
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
