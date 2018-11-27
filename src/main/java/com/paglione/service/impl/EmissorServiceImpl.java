package com.paglione.service.impl;

import com.paglione.entity.Emissor;
import com.paglione.entity.Endereco;
import com.paglione.repository.EmissorRepository;
import com.paglione.service.EmissorService;
import com.paglione.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class EmissorServiceImpl implements EmissorService {
    private static Logger logger = Logger.getLogger(EmissorServiceImpl.class);

    @Autowired
    private EmissorRepository emissorRepository;
    @Autowired
    private EnderecoService enderecoService;

    public void setEmissorRepository(EmissorRepository emissorRepository) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        this.emissorRepository = emissorRepository;
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void setEmissorService(EnderecoService enderecoService) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        this.enderecoService = enderecoService;
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public List<Emissor> retrieveEmissors() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        List<Emissor> emissors = emissorRepository.findAll();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return emissors;
    }

    public Emissor getEmissor(Long emissorId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Optional<Emissor> optEmp = emissorRepository.findById(emissorId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return optEmp.get();
    }

    public void saveEmissor(Emissor emissor) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        emissorRepository.save(emissor);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void deleteEmissor(Long emissorId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        emissorRepository.deleteById(emissorId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void updateEmissor(Emissor emissor) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        emissor.setEndereco(updateAddress(emissor.getEndereco()));
        System.out.println("Atualizar Emissor antes: " + emissor);
        emissorRepository.save(emissor);
    }

    private Endereco updateAddress(Endereco endereco) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        if (endereco == null || endereco.getId() == null) {
            System.out.println("Endereco novo identificado - add");
            endereco.setId(enderecoService.saveEndereco(endereco));
            logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
            return endereco;
        } else {
            System.out.println("Endereco existente - atuazalizar: Begin: " + endereco);
            enderecoService.updateEndereco(endereco);
            System.out.println("Endereco existente - atuazalizar: End: " + endereco);
            logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
            return endereco;
        }
    }
}