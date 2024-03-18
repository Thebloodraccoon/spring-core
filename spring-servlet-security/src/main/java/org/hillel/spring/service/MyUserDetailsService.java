package org.hillel.spring.service;


import lombok.RequiredArgsConstructor;
import org.hillel.spring.model.MyUserDetails;
import org.hillel.spring.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserDetails(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " is absent")));
    }
}