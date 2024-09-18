package cl.negenko.Proyecto.Ventas.controller;

import cl.negenko.Proyecto.Ventas.model.entities.Cliente;
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
        model.addAttribute("producto", productoService.findOne(id));
        return "productoEdit";
    }

    @GetMapping("producto/{id}")
    public String findOneP(@PathVariable("id") int id, Model model){
        model.addAttribute("producto", productoService.findOne(id));
        return "productoView";
    }

    @PostMapping
    public String update(@RequestParam int idProducto, @ModelAttribute Producto productoActualizado) {
        productoService.update(idProducto, productoActualizado);
        return "redirect:/productos";
    }

    @GetMapping("/new")
    public String toCreate(Model model){
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
