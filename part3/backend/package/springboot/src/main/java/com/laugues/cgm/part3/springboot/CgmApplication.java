package com.laugues.cgm.part3.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;

/**
 * Application Running class[
 */
@SpringBootApplication(scanBasePackages = "com.laugues", exclude = {ErrorMvcAutoConfiguration.class})
public class CgmApplication
{

    public static void main(String[] args) {
        SpringApplication.run(CgmApplication.class, args);
    }

}
