package com.paglione.controller;

import com.paglione.entity.Emissor;
import com.paglione.service.EmissorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmissorRestController {
    private static Logger logger = Logger.getLogger(EmissorRestController.class);
    final private static String API = "/api/emissors";
    @Autowired
    private EmissorService emissorService;

    public void setEmissorService(EmissorService emissorService) {
        this.emissorService = emissorService;
    }

    @GetMapping(API)
    public Emissor getEmissors() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("GetMapping: " + API);
        Emissor emissors = emissorService.retrieveEmissors().stream().findFirst().orElse(null);
        logger.info("Return : " + emissors + " another way: " + emissorService.retrieveEmissors());
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return emissors;
    }

    @PutMapping(API + "/{emissorId}")
    public void updateEmissor(@RequestBody Emissor emissor, @PathVariable(name = "emissorId") Long emissorId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("PutMapping: " + API + "{" + emissorId + "} - Emissor: " + emissor);

        Emissor emp = emissorService.getEmissor(emissorId);
        System.out.println("Buscar emissor no banco: " + emp);
        if (emp != null) {
            System.out.println("Emissor encontrado - atualizar endereco");
            emissorService.updateEmissor(emissor);
            System.out.println("Atualizar Emissor depois: " + emissor);
        }

        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }


}