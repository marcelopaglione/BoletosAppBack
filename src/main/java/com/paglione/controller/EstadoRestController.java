package com.paglione.controller;

import com.paglione.entity.Estado;
import com.paglione.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.log4j.Logger;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoRestController {

    private static final Logger logger = Logger.getLogger(EstadoRestController.class);

    @Autowired
    private EstadoService estadoService;

    public void setEstadoService(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping(path = "/api/estados", params = "sigla")
    public List<Estado> getEstadoBySigla(@RequestParam(value = "sigla") String sigla) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("@GetMapping(path = \"/api/estados\", params = \"{sigla}\")");
        System.out.println("Param " + sigla);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return estadoService.retrieveEstados().stream().filter(e -> e.getSigla().equals(sigla.trim())).collect(Collectors.toList());
    }

    @GetMapping("/api/estados")
    public List<Estado> getEstados() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("@GetMapping(\"/api/estados\")");
        List<Estado> estados = estadoService.retrieveEstados();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return estados;
    }

    @GetMapping("/api/estados/{estadoId}")
    public Estado getEstado(@PathVariable(name = "estadoId") Long estadoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return estadoService.getEstado(estadoId);
    }

    @PostMapping("/api/estados")
    public void saveEstado(Estado estado) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        estadoService.saveEstado(estado);
        System.out.println("Estado Saved Successfully");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @DeleteMapping("/api/estados/{estadoId}")
    public void deleteEstado(@PathVariable(name = "estadoId") Long estadoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        estadoService.deleteEstado(estadoId);
        System.out.println("Estado Deleted Successfully");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @PutMapping("/api/estados/{estadoId}")
    public void updateEstado(@RequestBody Estado estado,
                             @PathVariable(name = "estadoId") Long estadoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Estado emp = estadoService.getEstado(estadoId);
        if (emp != null) {
            estadoService.updateEstado(estado);
        }
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());

    }


}