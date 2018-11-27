package com.paglione.service.impl;

import com.paglione.entity.Estado;
import com.paglione.repository.EstadoRepository;
import com.paglione.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class EstadoServiceImpl implements EstadoService {
    private static Logger logger = Logger.getLogger(EstadoServiceImpl.class);

    @Autowired
    private EstadoRepository estadoRepository;

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> retrieveEstados() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        List<Estado> estados = estadoRepository.findAll();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return estados;
    }

    public Estado getEstado(Long estadoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Optional<Estado> optEmp = estadoRepository.findById(estadoId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return optEmp.get();
    }

    public void saveEstado(Estado estado) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        estadoRepository.save(estado);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void deleteEstado(Long estadoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        estadoRepository.deleteById(estadoId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void updateEstado(Estado estado) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        estadoRepository.save(estado);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}