package com.cesuokanc.druid.rawdata;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class RawdataDbConfig {

    @Autowired
    private RawDataDbSetting rawDataDbSetting;

    @Bean("rawDataSource")
    public DataSource rawDataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setPassword(rawDataDbSetting.getPassword());
        datasource.setUsername(rawDataDbSetting.getUserName());
        datasource.setDriverClassName(rawDataDbSetting.getDriverClassName());
        datasource.setMaxActive(rawDataDbSetting.getMaxActive());
        datasource.setInitialSize(rawDataDbSetting.getInitialSize());
        datasource.setUrl(rawDataDbSetting.getUrl());
        return datasource;
    }


    @Bean("rawDataSqlSessionFactory")
    public SqlSessionFactoryBean  sqlSessionFactoryBean(@Qualifier("rawDataSource") DataSource dataSource){
        SqlSessionFactoryBean  sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
}
