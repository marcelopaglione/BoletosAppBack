package com.paglione.service;

import com.paglione.entity.Cidade;

import java.util.List;

/**
 * @author JavaSolutionsGuide
 */
public interface CidadeService {
    List<Cidade> retrieveCidades();

    Cidade getCidadeById(Long cidadeId);

    Cidade getCidadeByEstado(Long cidadeEstado);

    void saveCidade(Cidade cidade);

    void deleteCidade(Long cidadeId);

    void updateCidade(Cidade cidade);
}