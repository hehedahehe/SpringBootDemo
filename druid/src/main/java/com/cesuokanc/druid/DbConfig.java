package com.cesuokanc.druid;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/5
*/
@Configuration
public class DbConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }
}
