package com.example.ssssksss_blog.blog.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * PackageName : com.example.ssssksss_blog.blog.dto
 * FileName : UserDto
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class UserSignupDto {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Pattern(regexp="[a-zA-Z0-9]{8,12}",message="비밀번호는 영어 소문자,대문자,숫자로 8자리이상 12자리이하로 구성됩니다.")
    private String cuid;
    @NotEmpty
    @Pattern(regexp="(?=.*\\d{1,20})(?=.*[~`!@#$%^&*()-+=]{1,20})(?=.*[a-z]{1,20})(?=.*[A-Z]{1,20})[a-zA-Z0-9~`!@#$%^&*()-+=]{8,20}$"
            ,message="8~16자리로 최소 소문자1개, 대문자1개, 숫자1개, 특수문자1개로 구성되야합니다.")
    private String password;
    @NotEmpty
    @Pattern(regexp="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$",
            message="example@test.com과 같은 이메일 형식이 아닙니다.")
    private String email;
    @NotEmpty
    @Pattern(regexp="[w|m]",message="m이나 w의 값이 들어와야 합니다.")
    private String gender;
    @NotEmpty
    @Pattern(regexp="^(19[0-9][0-9]|20[0-9]{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$",message="올바른 8자리의 숫자로 구성되야합니다.")
    private String birthDate;
}
