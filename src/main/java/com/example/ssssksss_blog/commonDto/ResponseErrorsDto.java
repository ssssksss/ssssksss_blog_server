package com.example.ssssksss_blog.commonDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorsDto {

    private static final long serialVersionUID = 1L;

    private int statusCode;
    private HashMap<String,Object> errorMsgs;

}
