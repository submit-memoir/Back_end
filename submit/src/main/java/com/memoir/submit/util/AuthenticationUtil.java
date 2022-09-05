package com.memoir.submit.util;

import com.memoir.submit.exception.UserNotAuthenticatedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class AuthenticationUtil {

    public static Optional<String> getUserInfo() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(((UserDetails)authentication.getPrincipal()).getUsername());
    }
}
