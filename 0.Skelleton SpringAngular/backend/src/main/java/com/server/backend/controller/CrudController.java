package com.server.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {


    @GetMapping("/titulo")
    public String tituloSitio() {
        return "Titulo de la WEB";
    }

    @GetMapping("/descripcion")
    public String descripcionSitio() {
        return "La descripción de tu sitio web es un aspecto fundamental para el éxito. La descripción se muestra debajo del título de tu sitio en los resultados del motor de búsqueda y podría ser el factor decisivo de un cliente para saber si visita tu página. Escribe una descripción que será relevante para los buscadores y comprensible para los motores de búsqueda.";
    }


}
