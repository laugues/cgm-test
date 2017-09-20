package com.lagues.cmg.part3.sprinboot;

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
