package com.memoir.submit.entity.user;

import com.memoir.submit.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserId(String userId);

    boolean existsByUserIdAndNickname(String userId, String nickName);
}
