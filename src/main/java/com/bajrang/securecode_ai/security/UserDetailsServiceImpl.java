package com.bajrang.securecode_ai.security;

import com.bajrang.securecode_ai.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl
        implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(
            String email)
            throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .map(user ->
                        org.springframework.security.core.userdetails.User
                                .builder()
                                .username(user.getEmail())
                                .password(user.getPassword())
                                .roles(user.getRole())
                                .build()
                )
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found"));
    }
}