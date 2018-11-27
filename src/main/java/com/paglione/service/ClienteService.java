package com.paglione.service;

import com.paglione.entity.Cliente;

import java.util.List;

/**
 * @author JavaSolutionsGuide
 */
public interface ClienteService {
    List<Cliente> retrieveClientes();

    Cliente getCliente(Long clienteId);

    void saveCliente(Cliente cliente);

    void deleteCliente(Long clienteId);

    void updateCliente(Cliente cliente);
}