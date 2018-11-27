package com.paglione.service.impl;

import com.paglione.entity.Cliente;
import com.paglione.repository.ClienteRepository;
import com.paglione.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class ClienteServiceImpl implements ClienteService {
    private static Logger logger = Logger.getLogger(ClienteServiceImpl.class);
    @Autowired
    private ClienteRepository clienteRepository;

    public void setClienteRepository(ClienteRepository clienteRepository) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        this.clienteRepository = clienteRepository;
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public List<Cliente> retrieveClientes() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        List<Cliente> clientes = clienteRepository.findAll();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return clientes;
    }

    public Cliente getCliente(Long clienteId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Optional<Cliente> optEmp = clienteRepository.findById(clienteId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return optEmp.get();
    }

    public void saveCliente(Cliente cliente) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        clienteRepository.save(cliente);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void deleteCliente(Long clienteId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        clienteRepository.deleteById(clienteId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void updateCliente(Cliente cliente) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        clienteRepository.save(cliente);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
