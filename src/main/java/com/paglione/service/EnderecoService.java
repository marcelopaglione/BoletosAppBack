package com.paglione.service;

import com.paglione.entity.Endereco;

import java.util.List;

/**
 * @author JavaSolutionsGuide
 */
public interface EnderecoService {
    List<Endereco> retrieveEnderecos();

    Endereco getEndereco(Long enderecoId);

    Long saveEndereco(Endereco endereco);

    void deleteEndereco(Long enderecoId);

    void updateEndereco(Endereco endereco);
}