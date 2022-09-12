package com.memoir.submit.dto.response;

import com.memoir.submit.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MemoirDetailResponse {

    Long id;

    String nickname;

    LocalDateTime date;

    String title;

    String goal;

    String learned;

    String felt;

    String nextGoal;
}
