package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityAdapter extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception
    {
        auth.userDetailsService( userDetailsService );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
        http.authorizeRequests().anyRequest().permitAll()
                //.antMatchers("/topic/update/*").hasRole("ADMIN")
//		.antMatchers("/topics/add/*").hasRole("ADMIN")
//		.antMatchers("/topics/delete/*").hasRole("ADMIN")
                //.antMatchers( "/topic/getAllTopics" ).hasRole( "ADMIN" )

//		.antMatchers("/topic/update").hasRole("ADMIN")
//		.antMatchers("/topic/add").hasRole("ADMIN")
//		.antMatchers("/topic/update").hasRole("ADMIN")
//		.antMatchers("/topic/delete").hasRole("ADMIN")
//		.antMatchers("/topic/getTopicById").hasRole("ADMIN")
                //.antMatchers("/topic").hasAnyRole("CONTRACTOR","ADMIN")
                //.antMatchers("/").permitAll()
                .and().formLogin();

    }

    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();

    }


}
