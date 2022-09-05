package com.memoir.submit.controller;

import com.memoir.submit.dto.request.WriteRequest;
import com.memoir.submit.dto.response.WriteResponse;
import com.memoir.submit.service.MemoirService;
import com.memoir.submit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class MemoirController {

    private final MemoirService memoirService;

    @PostMapping("/memoir/write")
    public WriteResponse write(WriteRequest request) {
        return memoirService.write(request);
    }
}
