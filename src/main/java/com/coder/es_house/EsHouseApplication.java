package com.coder.es_house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EsHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsHouseApplication.class, args);
    }

    @GetMapping("/es_house")
    public String getEsHouse(){
        return "welcome es_house";
    }
}

