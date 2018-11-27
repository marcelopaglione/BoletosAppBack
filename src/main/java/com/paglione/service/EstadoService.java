package com.paglione.service;

import com.paglione.entity.Estado;

import java.util.List;

/**
 * @author JavaSolutionsGuide
 */
public interface EstadoService {
    List<Estado> retrieveEstados();

    Estado getEstado(Long employeeId);

    void saveEstado(Estado estado);

    void deleteEstado(Long employeeId);

    void updateEstado(Estado estado);
}