package com.memoir.submit.service;

import com.memoir.submit.dto.request.WriteRequest;
import com.memoir.submit.dto.response.WriteResponse;
import com.memoir.submit.entity.memoir.Memoir;
import com.memoir.submit.entity.memoir.MemoirRepository;
import com.memoir.submit.entity.user.User;
import com.memoir.submit.entity.user.UserRepository;
import com.memoir.submit.exception.UserNotAuthenticatedException;
import com.memoir.submit.util.AuthenticationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemoirServiceImpl implements MemoirService {

    private final MemoirRepository memoirRepository;
    private final UserRepository userRepository;

    @Override
    public WriteResponse write(WriteRequest request) {

        return new WriteResponse(memoirRepository.save(Memoir.builder()
                .title(request.getTitle())
                .goal(request.getGoal())
                .learned(request.getLearned())
                .felt(request.getFelt())
                .next_goal(request.getNextGoal())
                .user(userInfo())
                .build()
        ).getId());
    }

    public User userInfo() {
        return AuthenticationUtil.getUserInfo()
                .flatMap(userRepository::findByUserId)
                .orElseThrow(()-> UserNotAuthenticatedException.EXCEPTION);
    }
}
