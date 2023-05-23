package com.desafio.autos.Controller;

import com.desafio.autos.Model.Auto;
import com.desafio.autos.Service.AutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/autos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AutoController {


    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping()
    public List<Auto> listadoAutos(){
        return autoService.getAllAutos();
    }


    @GetMapping("/generar/{cantidad}")
    public List<Auto> generarAutomoviles(@PathVariable int cantidad) {
        List<Auto> autos = autoService.generarAutos(cantidad);
        System.out.println(autos);
        return autos;
    }

    @PostMapping("/filtrar/{opcionFiltro}/{precio}")
    public List<Auto> filtrarAutos(@PathVariable String opcionFiltro, @PathVariable int precio) {
        return autoService.filtrarPorPrecio(precio, opcionFiltro);
    }

    @PostMapping("/eliminar")
    public void eliminarAutos() {
        autoService.eliminarAutos();
    }


}
