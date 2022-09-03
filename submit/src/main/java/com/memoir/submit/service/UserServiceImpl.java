package com.memoir.submit.service;

import com.memoir.submit.dto.request.LoginRequest;
import com.memoir.submit.dto.request.SignupRequest;
import com.memoir.submit.dto.response.TokenResponse;
import com.memoir.submit.entity.user.User;
import com.memoir.submit.entity.user.UserRepository;
import com.memoir.submit.exception.PasswordNotMatchException;
import com.memoir.submit.exception.UserNotFoundException;
import com.memoir.submit.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void signup(SignupRequest request) {

        String userId = request.getUserId();
        String password = passwordEncoder.encode(request.getPassword());
        String nickname = request.getNickname();

        if(userRepository.existsByUserIdAndNickname(request.getUserId(), request.getNickname())) {
            throw UserNotFoundException.EXCEPTION;
        }

         User user = userRepository.save(User.builder()
                 .userId(userId)
                 .password(password)
                 .nickname(nickname)
                 .build());

    }

    @Override
    public TokenResponse login(LoginRequest request) {

        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(()->UserNotFoundException.EXCEPTION);

        String password = user.getPassword();

        if(passwordEncoder.matches(password, request.getPassword()))
            throw PasswordNotMatchException.EXCEPTION;

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.getAccessToken(user.getId()))
                .build();
    }
}
