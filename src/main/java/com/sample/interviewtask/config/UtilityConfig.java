package com.sample.interviewtask.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by TapuMandal on 5/4/2021.
 * For any query ask online.tapu@gmail.com
 */

@Configuration
public class UtilityConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
