package com.example.ssssksss_blog.commonDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatusDto {
    private static final long serialVersionUID = 1L;

    private int statusCode;
    private String msg;
    @Builder.Default private Boolean successFlag = true;

    public ResponseStatusDto(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }
}
