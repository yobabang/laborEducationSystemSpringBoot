package com.flex.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import org.apache.ibatis.type.DateTypeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            configuration.getTypeHandlerRegistry().register(Date.class, new DateTypeHandler());
        };
    }

}

