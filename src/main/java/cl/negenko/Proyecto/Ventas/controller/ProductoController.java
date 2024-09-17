package cl.negenko.Proyecto.Ventas.controller;

import cl.negenko.Proyecto.Ventas.model.entities.Producto;
import cl.negenko.Proyecto.Ventas.model.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;


    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("productos", productoService.findAll());
        return "productosList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("cliente", productoService.findOne(id));
        return "productoEdit";
    }

    @GetMapping("cliente/{id}")
    public String findOneP(@PathVariable("id") int id, Model model){
        model.addAttribute("cliente", productoService.findOne(id));
        return "productoOneList";
    }

    @PostMapping
    public String update(@ModelAttribute Producto producto) {
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/new")
    public String toCreate(Model model){
        model.addAttribute("productos", productoService.findAll());
        return "productoNew";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Producto producto) {
        productoService.create(producto);
        return "redirect:/productos";
    }

    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = productoService.delete(id);
        return "redirect:/productos";
    }

}
