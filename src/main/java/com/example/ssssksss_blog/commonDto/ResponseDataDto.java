package com.example.ssssksss_blog.commonDto;

import lombok.*;

import java.util.HashMap;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataDto {

    private static final long serialVersionUID = 1L;

    private int statusCode;
    private String msg;
    private HashMap<String,Object> data;
    @Builder.Default private Boolean successFlag = true;

    public ResponseDataDto(String msg, HashMap<String, Object> data, Boolean successFlag) {
        this.msg = msg;
        this.data = data;
        this.successFlag = successFlag;
    }
    public ResponseDataDto(String msg, HashMap<String, Object> data) {
        this.msg = msg;
        this.data = data;
    }
}
