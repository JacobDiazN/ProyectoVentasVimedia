package cl.negenko.Proyecto.Ventas.model.service;

import cl.negenko.Proyecto.Ventas.model.entities.*;
import cl.negenko.Proyecto.Ventas.model.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final DireccionRepository direccionRepository;
    private final ComunaRepository comunaRepository;
    private final TipoViviendaRepository tipoViviendaRepository;
    private final RegionRepository regionRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository, DireccionRepository direccionRepository, ComunaRepository comunaRepository, TipoViviendaRepository tipoViviendaRepository, RegionRepository regionRepository) {
        this.clienteRepository = clienteRepository;
        this.direccionRepository = direccionRepository;
        this.comunaRepository = comunaRepository;
        this.tipoViviendaRepository = tipoViviendaRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findOne(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente update(int id, Cliente clienteActualizado, Direccion direccionActualizada, int idComuna, int idTipoVivienda, int idRegion) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setApellido(clienteActualizado.getApellido());
            cliente.setCorreo(clienteActualizado.getCorreo());
            cliente.setTelefono(clienteActualizado.getTelefono());


                direccionRepository.findById(cliente.getDireccion().getIdDireccion()).ifPresent(direccion -> {
                direccion.setCalle(direccionActualizada.getCalle());
                direccion.setNumero(direccionActualizada.getNumero());
                direccion.setDetalle(direccionActualizada.getDetalle());

                comunaRepository.findById(idComuna).ifPresent(direccion::setComuna);
                tipoViviendaRepository.findById(idTipoVivienda).ifPresent(direccion::setTipoVivienda);
                regionRepository.findById(idRegion).ifPresent(direccion::setRegion);

                direccionRepository.save(direccion);
            });

            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
    }



    @Override
    public Cliente create(Cliente cliente, int idComuna, int idTipoVivienda, int idRegion, Direccion direccion) {
        // Obtener la Comuna, Tipo de Vivienda y Región seleccionadas
        Optional<Comuna> comuna = comunaRepository.findById(idComuna);
        Optional<TipoVivienda> tipoVivienda = tipoViviendaRepository.findById(idTipoVivienda);
        Optional<Region> region = regionRepository.findById(idRegion);

        if(comuna.isPresent() && tipoVivienda.isPresent() && region.isPresent()) {
            // Asignar la comuna, tipo de vivienda y región a la dirección
            direccion.setComuna(comuna.get());
            direccion.setRegion(region.get());
            direccion.setTipoVivienda(tipoVivienda.get());

            // Guardar la dirección en la base de datos
            Direccion savedDireccion = direccionRepository.save(direccion);

            // Asignar la dirección al cliente y guardarlo
            cliente.setDireccion(savedDireccion);
            return clienteRepository.save(cliente);
        } else {
            // Lógica para manejar si alguno de los IDs no existe
            throw new IllegalArgumentException("Comuna, Tipo de Vivienda o Región inválidos");
        }
    }

    @Override
    public boolean delete(int id) {
        boolean exist = clienteRepository.existsById(id);
        if(exist){
            clienteRepository.deleteById(id);
        }
        return exist;
    }
}
