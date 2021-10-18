package com.whynotyue.community.config;

import com.whynotyue.community.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.text.SimpleDateFormat;

// 装配第三方 bean
@Configuration
public class AlphaConfig {

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Bean
    public ThreadLocal<User> threadLocal(){
        return new ThreadLocal<>();
    }
}
