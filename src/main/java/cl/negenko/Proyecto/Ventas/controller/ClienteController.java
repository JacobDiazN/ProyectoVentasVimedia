package cl.negenko.Proyecto.Ventas.controller;

import cl.negenko.Proyecto.Ventas.model.entities.*;
import cl.negenko.Proyecto.Ventas.model.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ComunaService comunaService;
    private final TipoViviendaService tipoViviendaService;
    private final RegionService regionService;

    public ClienteController(ClienteService clienteService, ComunaService comunaService, TipoViviendaService tipoViviendaService, RegionService regionService) {
        this.clienteService = clienteService;
        this.comunaService = comunaService;
        this.tipoViviendaService = tipoViviendaService;
        this.regionService = regionService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("clientes", clienteService.findAll());
        return "clientesList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("cliente", clienteService.findOne(id));
        model.addAttribute("comunas", comunaService.findAll());
        model.addAttribute("tipoViviendas", tipoViviendaService.findAll());
        model.addAttribute("regiones", regionService.findAll());
        return "clienteEdit";
    }

    @GetMapping("cliente/{id}")
    public String findOneP(@PathVariable("id") int id, Model model){
        model.addAttribute("cliente", clienteService.findOne(id));
        return "clienteOneList";
    }

    @PostMapping
    public String update(@RequestParam int idCliente, @ModelAttribute Cliente clienteActualizado, @ModelAttribute Direccion direccionActualizada, @RequestParam int idComuna, @RequestParam int idTipoVivienda, @RequestParam int idRegion, Model model) {
        clienteService.update(idCliente, clienteActualizado, direccionActualizada, idComuna, idTipoVivienda, idRegion);
        // Redirigir a una vista correcta o actualizar el modelo y retornar la vista correcta
        //model.addAttribute("cliente", clienteService.findOne(idCliente));
        //model.addAttribute("comunas", comunaService.findAll());
        //model.addAttribute("tipoViviendas", tipoViviendaService.findAll());
        //model.addAttribute("regiones", regionService.findAll());
        return "redirect:/clientes";
    }

    @GetMapping("/new")
    public String toCreate(Model model){
        model.addAttribute("comunas", comunaService.findAll());
        model.addAttribute("tipoViviendas", tipoViviendaService.findAll());
        model.addAttribute("regiones", regionService.findAll());
        return "clienteNew";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Cliente cliente, @RequestParam int idComuna, @RequestParam int idTipoVivienda, @RequestParam int idRegion, @ModelAttribute Direccion direccion) {
        clienteService.create(cliente, idComuna, idTipoVivienda, idRegion, direccion);
        return "redirect:/clientes";
    }

    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = clienteService.delete(id);
        return "redirect:/clientes";
    }

}
