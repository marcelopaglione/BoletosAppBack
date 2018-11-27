package com.paglione.service.impl;

import com.paglione.entity.Config;
import com.paglione.repository.ConfigRepository;
import com.paglione.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class ConfigServiceImpl implements ConfigService {
    private static Logger logger = Logger.getLogger(ConfigServiceImpl.class);
    @Autowired
    private ConfigRepository configRepository;

    public void setConfigRepository(ConfigRepository configRepository) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        this.configRepository = configRepository;
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public List<Config> retrieveConfig() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        List<Config> configs = configRepository.findAll();
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return configs;
    }

    @Override
    public Config getConfig(Long configId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        Optional<Config> config = configRepository.findById(configId);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return config.get();
    }

    public void updateConfig(Config config) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        configRepository.save(config);
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}