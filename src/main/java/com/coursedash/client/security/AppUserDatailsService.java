package com.coursedash.client.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.coursedash.client.model.User;
import com.coursedash.client.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDatailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found."));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassworld(),
                getRoles(user));
    }

    private Collection<? extends GrantedAuthority> getRoles(User user) {
        Set<SimpleGrantedAuthority> auth =  new HashSet<>();
        user.getRoles().forEach(
            role -> auth.add(new SimpleGrantedAuthority(role.getDescription().toUpperCase())));
        return auth;
    }
    
}
