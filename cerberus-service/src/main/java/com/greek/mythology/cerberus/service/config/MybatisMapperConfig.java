/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.service.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangpeng
 *         date 2018年07月23日
 *         desc
 */
@Configuration
public class MybatisMapperConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        scannerConfigurer.setBasePackage("com.greek.mythology.cerberus.service.mapper");
        return scannerConfigurer;
    }
}
