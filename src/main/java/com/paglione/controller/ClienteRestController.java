package com.paglione.controller;

import com.paglione.BoletosApplication;
import com.paglione.entity.Cliente;
import com.paglione.service.ClienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteRestController {
    private static Logger logger = Logger.getLogger(BoletosApplication.class);

    @Autowired
    private ClienteService clienteService;

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/api/clientes")
    public List<Cliente> getClientes() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());

        List<Cliente> clientes = clienteService.retrieveClientes();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return clientes;
    }

    @GetMapping("/api/clientes/{clienteId}")
    public Cliente getCliente(@PathVariable(name = "clienteId") Long clienteId) {
        logger.info("[START]" + Thread.currentThread().getStackTrace()[1].getMethodName());

        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return clienteService.getCliente(clienteId);
    }

    @PostMapping("/api/clientes")
    public void saveCliente(@RequestBody Cliente cliente) {
        logger.info("[START]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("Received Cliente: " + cliente);
        clienteService.saveCliente(cliente);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @DeleteMapping("/api/clientes/{clienteId}")
    public void deleteCliente(@PathVariable(name = "clienteId") Long clienteId) {
        logger.info("[START]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        clienteService.deleteCliente(clienteId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @PutMapping("/api/clientes/{clienteId}")
    public void updateCliente(@RequestBody Cliente cliente, @PathVariable(name = "clienteId") Long clienteId) {
        logger.info("[START]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        Cliente emp = clienteService.getCliente(clienteId);
        if (emp != null) {
            clienteService.updateCliente(cliente);
        }
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }


}