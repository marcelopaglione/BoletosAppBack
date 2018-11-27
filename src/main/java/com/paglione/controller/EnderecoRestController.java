package com.paglione.controller;

import com.paglione.entity.Endereco;
import com.paglione.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.log4j.Logger;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EnderecoRestController {

    private static final Logger logger = Logger.getLogger(EnderecoRestController.class);


    @Autowired
    private EnderecoService enderecoService;

    public void setEnderecoService(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/api/enderecos")
    public List<Endereco> getEnderecos() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("GetMapping: /api/enderecos");
        List<Endereco> enderecos = enderecoService.retrieveEnderecos();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return enderecos;
    }

    @GetMapping("GetMapping: /api/enderecos/{enderecoId}")
    public Endereco getEndereco(@PathVariable(name = "enderecoId") Long enderecoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("/api/enderecos/{" + enderecoId + "}");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return enderecoService.getEndereco(enderecoId);
    }

    @PostMapping("/api/enderecos")
    public void saveEndereco(Endereco endereco) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("PostMapping: /api/enderecos: " + endereco);
        enderecoService.saveEndereco(endereco);
        System.out.println("Endereco Saved Successfully");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @DeleteMapping("/api/enderecos/{enderecoId}")
    public void deleteEndereco(@PathVariable(name = "enderecoId") Long enderecoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("DeleteMapping: /api/enderecos/{" + enderecoId + "}");
        enderecoService.deleteEndereco(enderecoId);
        System.out.println("Endereco Deleted Successfully");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @PutMapping("/api/enderecos/{enderecoId}")
    public void updateEndereco(@RequestBody Endereco endereco,
                               @PathVariable(name = "enderecoId") Long enderecoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("PutMapping: /api/enderecos/{" + enderecoId + "}");
        Endereco emp = enderecoService.getEndereco(enderecoId);
        if (emp != null) {
            enderecoService.updateEndereco(endereco);
        }

        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}