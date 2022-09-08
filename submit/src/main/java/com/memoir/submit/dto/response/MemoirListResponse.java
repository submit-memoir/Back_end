package com.memoir.submit.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class MemoirListResponse {

    private final List<memoirList> memoirs;

    @Getter
    @Builder
    public static class memoirList {

        private final Long id;

        private final String title;

        private final String learned;

        private final LocalDateTime created_at;
    }
}
