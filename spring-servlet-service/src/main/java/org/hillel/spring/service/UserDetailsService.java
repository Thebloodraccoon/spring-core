package org.hillel.spring.service;

import lombok.AllArgsConstructor;
import org.hillel.spring.model.details.UserDetails;
import org.hillel.spring.repo.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetails(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " is absent")));
    }
}