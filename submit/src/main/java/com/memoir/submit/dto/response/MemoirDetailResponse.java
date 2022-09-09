package com.memoir.submit.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MemoirDetailResponse {

    String nickname;

    LocalDateTime date;

    String title;

    String goal;

    String learned;

    String felt;

    String nextGoal;
}
