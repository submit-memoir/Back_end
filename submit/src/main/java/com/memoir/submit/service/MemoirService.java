package com.memoir.submit.service;

import com.memoir.submit.dto.request.WriteRequest;
import com.memoir.submit.dto.response.MemoirListResponse;
import com.memoir.submit.dto.response.WriteResponse;

public interface MemoirService {

    WriteResponse write(WriteRequest request);
    MemoirListResponse getMemoirList();
}
