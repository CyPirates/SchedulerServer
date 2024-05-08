package com.example.schedulerserver.domain.user.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @Size(max = 30)
    @NotEmpty(message = "id는 필수 입력사항입니다.")
    private String userid;

    @Size(max=30)
    @NotEmpty(message = "이름은 필수 입력사항입니다.")
    private String name;

    @NotEmpty(message = "비밀번호는 필수 입력사항입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수 입력사항입니다.")
    private String password2;
}
