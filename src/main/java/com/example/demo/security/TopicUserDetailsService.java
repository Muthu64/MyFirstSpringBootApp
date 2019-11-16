package com.example.demo.security;

import com.example.demo.DTO.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
    {

        Optional<User> user = userRepository.findByUserName( username );
        System.out.println( "user-->" + user );
        user.orElseThrow( () -> new UsernameNotFoundException( "Not found: " + username ) );

        UserDetails ud = user.map( TopicUserDetails::new ).get();
        System.out.println( ud );
        return ud;
    }

}
