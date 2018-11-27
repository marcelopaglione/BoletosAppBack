package com.paglione.service.impl;

import com.paglione.entity.Cidade;
import com.paglione.repository.CidadeRepository;
import com.paglione.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class CidadeServiceImpl implements CidadeService {
    private static Logger logger = Logger.getLogger(CidadeServiceImpl.class);
    @Autowired
    private CidadeRepository cidadeRepository;

    public void setCidadeRepository(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<Cidade> retrieveCidades() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        List<Cidade> cidades = cidadeRepository.findAll();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return cidades;
    }

    public Cidade getCidadeById(Long cidadeId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Optional<Cidade> optEmp = cidadeRepository.findById(cidadeId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return optEmp.get();
    }

    public Cidade getCidadeByEstado(Long cidadeId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Optional<Cidade> optEmp = cidadeRepository.findById(cidadeId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return optEmp.get();
    }

    public void saveCidade(Cidade cidade) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        cidadeRepository.save(cidade);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void deleteCidade(Long cidadeId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        cidadeRepository.deleteById(cidadeId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void updateCidade(Cidade cidade) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        cidadeRepository.save(cidade);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}