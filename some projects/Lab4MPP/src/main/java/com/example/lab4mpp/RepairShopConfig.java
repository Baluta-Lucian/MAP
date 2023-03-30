package com.example.lab4mpp;

import com.example.lab4mpp.repository.ComputerRepairRequestRepository;
import com.example.lab4mpp.repository.ComputerRepairedFormRepository;
import com.example.lab4mpp.repository.jdbc.ComputerRepairRequestJdbcRepository;
import com.example.lab4mpp.repository.jdbc.ComputerRepairedFormJdbcRepository;
import com.example.lab4mpp.services.ComputerRepairServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class RepairShopConfig {
    @Bean
    Properties getProps() {
        Properties props = new Properties();
        try{
            System.out.println("Searching bd.config in directory " + ((new File(".")).getAbsolutePath()));
            props.load(new FileReader("bd.config"));

        }catch (IOException e){
            System.err.println("Configuration file bd.config not found " + e);

        }
        return props;

    }

    @Bean
    ComputerRepairRequestRepository requestsRepo(){
        return new ComputerRepairRequestJdbcRepository(getProps());
    }

    @Bean
    ComputerRepairedFormRepository formsRepo(){
        return new ComputerRepairedFormJdbcRepository(getProps());
    }

    @Bean
    ComputerRepairServices services(){
        return new ComputerRepairServices(requestsRepo(), formsRepo());
    }

}

