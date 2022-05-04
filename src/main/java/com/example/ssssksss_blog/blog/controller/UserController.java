package com.example.ssssksss_blog.blog.controller;

import com.example.ssssksss_blog.blog.dto.UserLoginDto;
import com.example.ssssksss_blog.blog.dto.UserSignupDto;
import com.example.ssssksss_blog.blog.service.UserService;
import com.example.ssssksss_blog.commonDto.ResponseStatusDto;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * PackageName : com.example.ssssksss_blog.blog.controller
 * FileName : UserController
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//   list(1) 회원가입
    @RequestMapping(value="/ssssksss/user/signup", method= RequestMethod.POST)
    public ResponseEntity userSignup(@Validated @RequestBody UserSignupDto userSignupDto, BindingResult bindingResult) {
        if(bindingResult.getFieldErrorCount()>0) {
            return userService.validateSignupParameter(bindingResult);
        }
        return userService.signup(userSignupDto);
    }

    //   list(2) 로그인
    @RequestMapping(value="/ssssksss/user/login", method= RequestMethod.POST)
    public ResponseEntity userLogin(@RequestBody UserLoginDto userLoginDto, BindingResult bindingResult, HttpServletResponse response) {
//        if(bindingResult.getFieldErrorCount()>0) {
//            return userService.validateLoginParameter(bindingResult);
//        }
        return userService.login(userLoginDto,response);
    }

    //   todo(1) 쿠키 받아오기
    //   todo(2) 쿠키가 없다면 refresh 받아오기
    //   todo(3) 쿠키 검증하러가기
    @RequestMapping(value="/ssssksss/user/validToken", method= RequestMethod.POST)
    public ResponseEntity validToken(@CookieValue("accessToken") String accessToken) {
        if(accessToken == null) {
            return null;
        }
        return userService.validateToken(accessToken);
    }

    @RequestMapping(value="/ssssksss/user/logout", method= RequestMethod.GET)
    public ResponseEntity removeToken(HttpServletResponse response) {

        return userService.removeToken(response);
    }

    //    todo(1) 패스워드 변경
//    public ResponseEntity changePassword(String header, HashMap<String,Object> requestData) {
//        JwtTokenManager jwtTokenManager = new JwtTokenManager();
//        Claims tokenPayload = jwtTokenManager.validTokenAndReturnBody(header);
//        if(tokenPayload==null) {
//            return ResponseEntity.status(401)
//                    .body(new ResponseStatusDto(401,"Invalid access Token"));
//        }
//        Optional<User> user = userRepository.findByEmail((String)tokenPayload.get("email"));
//        if(!user.get().getPassword().equals(requestData.get("password"))){
//            return ResponseEntity.badRequest()
//                    .body(new ResponseStatusDto(400,"The passwords do not match"));
//        }
//        else {
//            user.get().updatePassword((String)requestData.get("newpassword"));
//            userRepository.save(user.get());
//            return ResponseEntity.ok()
//                    .body(new ResponseStatusDto(200,"Change Password Success"));
//        }
//    }

    //    todo(1) 액세스 토큰 재발급
//    public ResponseEntity updateToken(Map<String,String> header) {
//        String clientAccessToken = header.get("Authorization").substring(7);
//        String clientRefreshToken = header.get("refreshToken").substring(7);
//        JwtTokenManager jwtTokenManager = new JwtTokenManager();
//        Claims tokenPayload = new JwtTokenManager().expiredTokenAndReturnBody(clientAccessToken);
//        if(tokenPayload==null) {
//            return ResponseEntity.status(401)
//                    .body(new ResponseStatusDto(401,"Invalid access Token"));
//        }
//        Optional<User> user = userRepository.findByEmail((String)tokenPayload.get("email"));
//        if(jwtTokenManager.isTokenExpired(user.get().getRefreshToken())) {
//            return ResponseEntity.badRequest()
//                    .body(new ResponseStatusDto(400,"The refresh token has expired"));
//        }
//        else if(!user.get().getRefreshToken().equals(clientRefreshToken)) {
//            return ResponseEntity.badRequest()
//                    .body(new ResponseStatusDto(400,"Refresh token values do not match"));
//        }else {
//            String newAccessToken = jwtTokenManager.createAccessToken(user.get());
//            return ResponseEntity.ok()
//                    .body(new ResponseTokenDto(200,"Successfully created a new access token",
//                            jwtTokenManager.createAccessToken(user.get())));
//        }
//    }

//    todo(1) 유저 탈퇴
//    public ResponseEntity removeUser(String header,HashMap<String,Object> requestData) {
//        JwtTokenManager jwtTokenManager = new JwtTokenManager();
//        Claims tokenPayload = new JwtTokenManager().validTokenAndReturnBody(header);
//        if(tokenPayload==null) {
//            return ResponseEntity.status(401)
//                    .body(new ResponseStatusDto(401,"Invalid access Token"));
//        }
//        Optional<User> user = userRepository.findByEmail((String)tokenPayload.get("email"));
//
//        if(!user.get().getPassword().equals(requestData.get("password"))) {
//            return ResponseEntity.badRequest()
//                    .body(new ResponseStatusDto(200,"Sign up Success"));
//        }else {
//            System.out.println("user"+user.get().getEmail());
//            userRepository.delete(user.get());
//            return ResponseEntity.ok()
//                    .body(new ResponseStatusDto(200,"Sign up Success"));
//        }
//    }


}

