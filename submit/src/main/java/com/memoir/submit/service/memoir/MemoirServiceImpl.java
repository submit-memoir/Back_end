package com.memoir.submit.service.memoir;

import com.memoir.submit.dto.request.WriteRequest;
import com.memoir.submit.dto.response.MemoirDetailResponse;
import com.memoir.submit.dto.response.MemoirListResponse;
import com.memoir.submit.dto.response.WriteResponse;
import com.memoir.submit.entity.memoir.Memoir;
import com.memoir.submit.entity.memoir.MemoirRepository;
import com.memoir.submit.entity.user.User;
import com.memoir.submit.entity.user.UserRepository;
import com.memoir.submit.exception.MemoirNotFoundException;
import com.memoir.submit.exception.UserNotAuthenticatedException;
import com.memoir.submit.util.AuthenticationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemoirServiceImpl implements MemoirService {

    private final MemoirRepository memoirRepository;
    private final UserRepository userRepository;

    @Override
    public WriteResponse write(WriteRequest request) {

/*        String user = userRepository.findNicknameById(userInfo().getId());*/

        return new WriteResponse(memoirRepository.save(Memoir.builder()
                .title(request.getTitle())
                .goal(request.getGoal())
                .learned(request.getLearned())
                .felt(request.getFelt())
                .next_goal(request.getNextGoal())
                .created_at(LocalDateTime.now())
                .nickName(userInfo().getNickname())
                .user(userInfo())
                .build()
        ).getId());
    }

    @Override
    public MemoirListResponse getMemoirList() {
        List<Memoir> memoirs = memoirRepository.findAllBy();
        return MemoirResponse(memoirs);

    }

    @Override
    public MemoirDetailResponse getMemoirDetail(Long id) {
        Memoir memoir = memoirRepository.findById(id)
                .orElseThrow(()-> MemoirNotFoundException.EXCEPTION);

        /*User nickname = userRepository.findNicknameById(memoir.getUser());*/

        MemoirDetailResponse response = MemoirDetailResponse.builder()
                .id(memoir.getId())
                .date(memoir.getCreated_at())
                .title(memoir.getTitle())
                .goal(memoir.getGoal())
                .learned(memoir.getLearned())
                .felt(memoir.getFelt())
                .nextGoal(memoir.getNext_goal())
                .nickname(memoir.getNickName())
                .build();

        return response;
    }


    public User userInfo() {
        return AuthenticationUtil.getUserInfo()
                .flatMap(userRepository::findByUserId)
                .orElseThrow(()-> UserNotAuthenticatedException.EXCEPTION);
    }

    private MemoirListResponse MemoirResponse (List<Memoir> memoirs) {
        List<MemoirListResponse.memoirList> memoirList = new ArrayList<>();

        // TODO 날짜 2022/09/29 이런식으로 반환되게 변경
        for(Memoir m : memoirs) {
            memoirList.add(
                    MemoirListResponse.memoirList.builder()
                            .id(m.getId())
                            .title(m.getTitle())
                            .learned(m.getLearned())
                            .created_at(m.getCreated_at())
                            .build()
            );
        };

        return new MemoirListResponse(memoirList);
    }
}
