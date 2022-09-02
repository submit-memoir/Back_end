package com.memoir.submit.security;

import com.memoir.submit.exception.handler.MemoirExceptionFilter;
import com.memoir.submit.security.jwt.JwtTokenFilter;
import com.memoir.submit.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(HttpSecurity http) {

        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider);
        MemoirExceptionFilter memoirExceptionFilter = new MemoirExceptionFilter();
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(memoirExceptionFilter, JwtTokenFilter.class);

    }
}
