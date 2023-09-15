package com.ijse.gdse.managementdivision.config;

import com.ijse.gdse.managementdivision.WebAppInitializer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
@Configuration
@ComponentScan(basePackageClasses = WebAppInitializer.class)
public class WebAppConfig {
    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}
}
