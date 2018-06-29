package com.cesuokanc.druid.rawdata;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/25
*/
@Data
@Configuration
@ConfigurationProperties(prefix = "datasource.rawdata")
public class RawDataDbSetting {
    private String url;
    private String userName;
    private String password;
    private String driverClassName = "com.mysql.jdbc.Driver";
    private Integer initialSize = 5;
    private Integer maxActive = 5;
}
