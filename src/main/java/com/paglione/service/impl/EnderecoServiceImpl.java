package com.paglione.service.impl;

import com.paglione.entity.Endereco;
import com.paglione.repository.CidadeRepository;
import com.paglione.repository.EnderecoRepository;
import com.paglione.repository.EstadoRepository;
import com.paglione.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    private static Logger logger = Logger.getLogger(EnderecoServiceImpl.class);
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    public void setEnderecoRepository(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void setCidadeRepository(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public List<Endereco> retrieveEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return enderecos;
    }

    public Endereco getEndereco(Long enderecoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Optional<Endereco> optEmp = enderecoRepository.findById(enderecoId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return optEmp.get();
    }

    public Long saveEndereco(Endereco endereco) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        enderecoRepository.save(endereco);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return endereco.getId();
    }

    public void deleteEndereco(Long enderecoId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        enderecoRepository.deleteById(enderecoId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void updateEndereco(Endereco endereco) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("UPDATE ENDERECO: " + endereco);
        if (endereco.getCidade() == null) {
            System.out.println("Cidade is NULL - create");
        }
        enderecoRepository.save(endereco);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}