package com.sparta.gamefeed.entity;

import com.sparta.gamefeed.dto.IntroduceRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String introduce;

    public User(String userId, String password, String email, String introduce) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.introduce = introduce;
    }

    public void changeUserInfo(IntroduceRequestDto requestDto) {
        if(requestDto.getEmail() != null){
            this.email = requestDto.getEmail();
        }

        if(requestDto.getIntroduce() != null){
            this.introduce = requestDto.getIntroduce();
        }

        if(requestDto.getChangePassword() != null){
            this.password = requestDto.getChangePassword();
        }
    }
}
