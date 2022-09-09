package com.memoir.submit.service.user;

import com.memoir.submit.dto.request.LoginRequest;
import com.memoir.submit.dto.request.SignupRequest;
import com.memoir.submit.dto.response.TokenResponse;

public interface UserService {

    void signup(SignupRequest request);
    TokenResponse login(LoginRequest request);
}
