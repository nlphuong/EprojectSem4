package com.shop.fashionShop;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ConfigurationAuto {
    @Scheduled(fixedDelay = 5*60*1000)
    public void run(){

    }
}
