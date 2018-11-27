package com.paglione.service;

import com.paglione.entity.Emissor;

import java.util.List;

/**
 * @author JavaSolutionsGuide
 */
public interface EmissorService {
    List<Emissor> retrieveEmissors();

    Emissor getEmissor(Long emissorId);

    void saveEmissor(Emissor emissor);

    void deleteEmissor(Long emissorId);

    void updateEmissor(Emissor emissor);
}