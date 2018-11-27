package com.paglione;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.paglione")
public class BoletosApplication {
    private static Logger logger = Logger.getLogger(BoletosApplication.class);

    public static void main(String[] args) throws IOException {
        logger.debug("App is starting");
        BasicConfigurator.configure();
        SpringApplication.run(BoletosApplication.class, args);
    }
}