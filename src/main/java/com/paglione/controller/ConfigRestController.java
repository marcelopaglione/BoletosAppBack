package com.paglione.controller;

import com.paglione.entity.Config;
import com.paglione.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConfigRestController {
    private static Logger logger = Logger.getLogger(ConfigRestController.class);
    @Autowired
    private ConfigService configService;

    public void setConfigService(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping("/api/configs")
    public Config getConfigs() {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("@GetMapping(\"/api/configs\")");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
        return configService.retrieveConfig().stream().findFirst().orElse(null);
    }

    @PutMapping("/api/configs/{configId}")
    public void updateConfig(@RequestBody Config config, @PathVariable(name = "configId") Long configId) {
        logger.info("[START] " + Thread.currentThread().getStackTrace()[1].getMethodName());

        Config cfg = configService.getConfig(configId);
        if (cfg != null) {
            configService.updateConfig(config);
        }
        System.out.println("Config Saved Successfully");
        logger.info("[END  ]" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}