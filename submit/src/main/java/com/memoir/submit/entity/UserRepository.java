package com.memoir.submit.entity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUserIdAndNickname(String userId, String nickName);
}
