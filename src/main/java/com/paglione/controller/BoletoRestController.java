package com.paglione.controller;

import com.paglione.entity.Boleto;
import com.paglione.service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BoletoRestController {
    private static Logger logger = Logger.getLogger(BoletoRestController.class);
    @Autowired
    private BoletoService boletoService;

    public void setBoletoService(BoletoService boletoService) {
        this.boletoService = boletoService;
    }

    @GetMapping("/api/boletos")
    public List<Boleto> getBoletos() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        List<Boleto> boletos = boletoService.retrieveBoletos().stream()
                .sorted(Comparator.comparing(item -> item.getCliente().getNome()))
                .collect(Collectors.toList());;
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return boletos;
    }

    @GetMapping("/api/boletos/{boletoId}")
    public Boleto getBoleto(@PathVariable(name = "boletoId") Long boletoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return boletoService.getBoleto(boletoId);
    }

    @PostMapping("/api/boletos")
    public void saveBoleto(@RequestBody Boleto boleto) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        boletoService.saveBoleto(boleto);
        System.out.println("Boleto Saved Successfully");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @DeleteMapping("/api/boletos/{boletoId}")
    public void deleteBoleto(@PathVariable(name = "boletoId") Long boletoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        boletoService.deleteBoleto(boletoId);
        System.out.println("Boleto Deleted Successfully");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @PutMapping("/api/boletos/{boletoId}")
    public void updateBoleto(@RequestBody Boleto boleto, @PathVariable(name = "boletoId") Long boletoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Boleto emp = boletoService.getBoleto(boletoId);
        if (emp != null) {
            boletoService.updateBoleto(boleto);
        }
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }


}