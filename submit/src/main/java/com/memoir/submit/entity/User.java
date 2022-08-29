package com.memoir.submit.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 15, unique = true, name = "userId")
    private String userId;

    @NotNull
    @Column(length = 8, unique = true)
    private String nickname;

    @NotNull
    @Column(length = 60)
    private String password;

    @NotNull
    @Column(length = 50)
    private String introduce;
}
