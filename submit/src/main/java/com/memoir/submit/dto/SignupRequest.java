package com.memoir.submit.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SignupRequest {

    @NotBlank(message = "아이디를 작성하세요.")
    @Length(min = 6, max = 15)
    private String userId;

    @NotBlank(message = "닉네임을 작성하세요.")
    @Length(min = 2, max = 8)
    private String nickname;

    @NotBlank(message = "비밀번호룰 작성하세요.")
    @Length(min = 8, max = 8)
    private String password;

    @NotBlank(message = "자기소개를 입력하세요.")
    @Length(min = 1, max = 50)
    private String introduce;
}

