package com.paglione.service.impl;

import com.paglione.entity.Boleto;
import com.paglione.repository.BoletoRepository;
import com.paglione.service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class BoletoServiceImpl implements BoletoService {
    private static Logger logger = Logger.getLogger(BoletoServiceImpl.class);

    @Autowired
    private BoletoRepository boletoRepository;

    public void setBoletoRepository(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    public List<Boleto> retrieveBoletos() {
        logger.info("[START] ");
        List<Boleto> boletos = boletoRepository.findAll();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return boletos;
    }

    public Boleto getBoleto(Long boletoId) {
        logger.info("[START] ");
        Optional<Boleto> optEmp = boletoRepository.findById(boletoId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return optEmp.get();
    }

    public void saveBoleto(Boleto boleto) {
        logger.info("[START] ");
        boletoRepository.save(boleto);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void deleteBoleto(Long boletoId) {
        logger.info("[START] ");
        boletoRepository.deleteById(boletoId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void updateBoleto(Boleto boleto) {
        logger.info("[START] ");
        boletoRepository.save(boleto);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}