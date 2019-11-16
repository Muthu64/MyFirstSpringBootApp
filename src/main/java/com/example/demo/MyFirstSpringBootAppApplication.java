package com.example.demo;

import com.example.demo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories( basePackageClasses = UserRepository.class )
public class MyFirstSpringBootAppApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( MyFirstSpringBootAppApplication.class, args );
    }

}
