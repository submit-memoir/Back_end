package com.memoir.submit.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);

    boolean existsByUserIdAndNickname(String userId, String nickname);

    String findNicknameById(User userId);
}
