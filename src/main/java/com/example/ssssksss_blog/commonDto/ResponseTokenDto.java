package com.example.ssssksss_blog.commonDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTokenDto {

    private static final long serialVersionUID = 1L;

    private int statusCode;
    private String msg;
    private String accessToken;
    private String refreshToken;
    @Builder.Default private Boolean successFlag = true;

    public ResponseTokenDto(int statusCode, String msg, String accessToken) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.accessToken = accessToken;
    }

    public ResponseTokenDto(int statusCode, String msg, String accessToken, String refreshToken) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
