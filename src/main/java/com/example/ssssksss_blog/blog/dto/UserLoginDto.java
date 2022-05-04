package com.example.ssssksss_blog.blog.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * PackageName : com.example.ssssksss_blog.blog.dto
 * FileName : UserLoginDto
 * Author : 이 수 경
 * Date : 2022-04-24
 * Description :
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class UserLoginDto {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Pattern(regexp="(?=.*\\d{1,20})(?=.*[~`!@#$%^&*()-+=]{1,20})(?=.*[a-z]{1,20})(?=.*[A-Z]{1,20})[a-zA-Z0-9~`!@#$%^&*()-+=]{8,20}$"
            ,message="8~16자리로 최소 소문자1개, 대문자1개, 숫자1개, 특수문자1개로 구성되야합니다.")
    private String password;
    @NotEmpty
    @Pattern(regexp="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$",
            message="example@test.com과 같은 이메일 형식이 아닙니다.")
    private String email;
}
