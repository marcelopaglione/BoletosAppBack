package com.paglione.controller;

import com.paglione.entity.Cidade;
import com.paglione.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.log4j.Logger;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CidadeRestController {
    private static Logger logger = Logger.getLogger(CidadeRestController.class);
    @Autowired
    private CidadeService cidadeService;

    public void setCidadeService(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/api/cidades")
    public List<Cidade> getCidades() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("@GetMapping(\"/api/cidades\")");
        List<Cidade> cidades = cidadeService.retrieveCidades();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return cidades;
    }

    @GetMapping(path = "/api/cidades", params = "estado")
    public List<Cidade> getCidadesByEstado(@RequestParam(value = "estado") int estado) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("@GetMapping(\"/api/cidades?estado={estado}\")");
        System.out.println("Estado: " + estado);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return cidadeService.retrieveCidades().stream().filter(c -> c.getEstado() == estado).collect(Collectors.toList());
    }

    @GetMapping(path = "/api/cidades", params = "nome")
    public List<Cidade> getCidadesByNome(@RequestParam(value = "nome") String nome) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("@GetMapping(\"/api/cidades?nome={nome}\")");
        System.out.println("nome: " + nome);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return cidadeService.retrieveCidades().stream().filter(c -> c.getNome().equals(nome.trim())).collect(Collectors.toList());
    }

    @PostMapping("/api/cidades")
    public void saveCidade(Cidade cidade) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("@PostMapping(\"/api/cidades\")");
        cidadeService.saveCidade(cidade);
        System.out.println("Cidade Saved Successfully");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @DeleteMapping("/api/cidades/{cidadeId}")
    public void deleteCidade(@PathVariable(name = "cidadeId") Long cidadeId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("@DeleteMapping(\"/api/cidades/{cidadeId}\")");
        cidadeService.deleteCidade(cidadeId);
        System.out.println("Cidade Deleted Successfully");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @PutMapping("/api/cidades/{cidadeId}")
    public void updateCidade(@RequestBody Cidade cidade, @PathVariable(name = "cidadeId") Long cidadeId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("@PutMapping(\"/api/cidades/{cidadeId}\")");
        Cidade emp = cidadeService.getCidadeById(cidadeId);
        if (emp != null) {
            cidadeService.updateCidade(cidade);
        }
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }


}