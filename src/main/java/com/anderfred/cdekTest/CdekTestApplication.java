package com.anderfred.cdekTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CdekTestApplication {
    static Logger logger = LoggerFactory.getLogger(CdekTestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CdekTestApplication.class, args);
		logger.info("Init");
    }
}
