package com.paglione.service;

import com.paglione.entity.Config;

import java.util.List;

/**
 * @author JavaSolutionsGuide
 */
public interface ConfigService {
    List<Config> retrieveConfig();

    Config getConfig(Long configId);

    void updateConfig(Config config);
}