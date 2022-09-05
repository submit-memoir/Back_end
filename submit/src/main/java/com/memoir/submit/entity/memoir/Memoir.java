package com.memoir.submit.entity.memoir;

import com.memoir.submit.entity.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Memoir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String title;

    @Column(length = 50)
    private String goal;

    @Column(length = 3000)
    private String learned;

    @Column(length = 100)
    private String felt;

    @Column(length = 50, name = "next_goal")
    private String next_goal;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    @LastModifiedDate
    private LocalDateTime created_at;
}
