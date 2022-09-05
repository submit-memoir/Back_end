package com.memoir.submit.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@AllArgsConstructor
public class WriteResponse {

    @NotNull
    private Long Id;
}
