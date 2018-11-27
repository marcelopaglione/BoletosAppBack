package com.paglione.service;

import com.paglione.entity.Boleto;

import java.util.List;

/**
 * @author JavaSolutionsGuide
 */
public interface BoletoService {
    List<Boleto> retrieveBoletos();

    Boleto getBoleto(Long boletoId);

    void saveBoleto(Boleto boleto);

    void deleteBoleto(Long boletoId);

    void updateBoleto(Boleto boleto);
}