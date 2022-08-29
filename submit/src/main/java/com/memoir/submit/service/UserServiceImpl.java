package com.memoir.submit.service;

import com.memoir.submit.dto.SignupRequest;
import com.memoir.submit.entity.User;
import com.memoir.submit.entity.UserRepository;
import com.memoir.submit.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    /*private final PasswordEncoder passwordEncoder;*/
    private final UserRepository userRepository;

    @Transactional
    public void signup(SignupRequest request) {

        String userId = request.getUserId();
        String password = request.getPassword();
        String nickname = request.getNickname();

        if(userRepository.existsByUserIdAndNickname(request.getUserId(), request.getNickname())) {
            throw ConflictException.EXCEPTION;
        }

         User user = userRepository.save(User.builder()
                .userId(userId)
                .nickname(nickname)
                 .password(password)
                .build());

    }
}
