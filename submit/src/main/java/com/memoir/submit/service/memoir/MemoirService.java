package com.memoir.submit.service.memoir;

import com.memoir.submit.dto.request.WriteRequest;
import com.memoir.submit.dto.response.MemoirDetailResponse;
import com.memoir.submit.dto.response.MemoirListResponse;
import com.memoir.submit.dto.response.WriteResponse;
import org.springframework.data.jpa.repository.Query;

public interface MemoirService {

    WriteResponse write(WriteRequest request);
    MemoirListResponse getMemoirList();

    MemoirDetailResponse getMemoirDetail(Long id);
}
