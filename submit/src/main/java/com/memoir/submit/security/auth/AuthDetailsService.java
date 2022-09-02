package com.memoir.submit.security.auth;

import com.memoir.submit.entity.user.UserRepository;
import com.memoir.submit.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return userRepository.findById(Long.valueOf(id))
                .map(AuthDetails::new)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }
}
