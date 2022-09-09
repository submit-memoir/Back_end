package com.memoir.submit.controller;

import com.memoir.submit.dto.request.WriteRequest;
import com.memoir.submit.dto.response.MemoirDetailResponse;
import com.memoir.submit.dto.response.MemoirListResponse;
import com.memoir.submit.dto.response.WriteResponse;
import com.memoir.submit.service.memoir.MemoirService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class MemoirController {
    private final MemoirService memoirService;

    @PostMapping("/memoir/write")
    public WriteResponse write(@RequestBody @Valid WriteRequest request) {
        return memoirService.write(request);
    }

    @GetMapping("/board")
    public MemoirListResponse getMemoirList() {
        return memoirService.getMemoirList();
    }

    @GetMapping("/board/{id}")
    public MemoirDetailResponse getMemoirDetail(@PathVariable Long id) {
        return memoirService.getMemoirDetail(id);
    }
}