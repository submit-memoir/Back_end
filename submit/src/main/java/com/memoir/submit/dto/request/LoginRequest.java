package com.memoir.submit.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {

    @NotBlank(message = "아이디를 입력해주세요.")
    @Length(min = 6, max = 15)
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Length(min = 6, max = 15)
    private String password;
}
