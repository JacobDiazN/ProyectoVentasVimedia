package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.Producto;
import cl.negenko.Proyecto.Ventas.model.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {


    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Producto findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Producto update(int id, Producto productoActualizado) {
        return repository.findById(id).map(producto -> {
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setImagenUrl(productoActualizado.getImagenUrl());

            return repository.save(producto);


        }).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
    }


    @Override
    public Producto create(Producto producto) {
        return repository.save(producto);
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
