package com.cesuokanc.druid.rawdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/5
*/
@Configuration
@MapperScan(basePackages = "com.fauinfo.bigdataetl.mapper.rawdata", sqlSessionFactoryRef = "rawDataSqlSessionFactory")
public class RawdataMybatisConfig {

}
