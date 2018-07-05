package com.cesuokanc.simpleweb.rest.config;

import com.cesuokanc.simpleweb.logic.LogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * @desc
 * @author lirb
 * @datetime 2018/5/24,11:04
 */
@Configuration
@ComponentScan(basePackages={
        "com.cesuokanc.simpleweb.logic",
})
public class BeansConfig {

    @Bean
    public LogicService getLogicService(){
        return new LogicService();
    }
}
