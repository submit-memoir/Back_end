package com.memoir.submit.dto.request;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
public class WriteRequest {

    @NotBlank(message = "아이디를 작성하세요.")
    @Length(min = 1, max = 30)
    private String title;

    @Length(min = 1, max = 50)
    private String goal;

    @NotBlank(message = "배운점을 작성하세요.")
    @Length(min = 1, max = 3000)
    private String learned;

    @Length(min = 1, max = 100)
    private String felt;

    @NotBlank(message = "다음 목표를 작성하세요.")
    @Length(min = 1, max = 15)
    private String nextGoal;

}
