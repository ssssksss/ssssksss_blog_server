package com.example.ssssksss_blog.blog.service;

import com.example.ssssksss_blog.blog.dao.User;
import com.example.ssssksss_blog.blog.dto.TokenDto;
import com.example.ssssksss_blog.blog.dto.UserLoginDto;
import com.example.ssssksss_blog.blog.dto.UserSignupDto;
import com.example.ssssksss_blog.blog.repository.UserRepository;
import com.example.ssssksss_blog.commonDto.ResponseDataDto;
import com.example.ssssksss_blog.commonDto.ResponseErrorDto;
import com.example.ssssksss_blog.commonDto.ResponseErrorsDto;
import com.example.ssssksss_blog.commonDto.ResponseStatusDto;
import com.example.ssssksss_blog.jwt.JwtTokenManager;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * PackageName : com.example.ssssksss_blog.blog.service
 * FileName : UserService
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */
@Service
public class UserService {

    @Value("${jwt.jwtSecret}")
    public static String jwtSecret;

    @Value("${domain.cookie}")
    public static String domainCookie;

//    private String domain = "ssssksss.xyz";
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private JwtTokenManager jwtTokenManager;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JwtTokenManager jwtTokenManager) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtTokenManager = jwtTokenManager;
    }

    public ResponseEntity signup(UserSignupDto userSignupDto) {
//        list(1) Validation은 이미 검사완료 (완료)
//        List(2) 데이터베이스에 저장되는 것 확인(완료)
//        list(3) DB에 사용자가 이미 존재하는지 확인 필요
//        list(@) 반환값을 프론트로 보내주어야 한다.
//        list(4) 패스워드 암호화
//        list(5) 데이터베이스에 저장
//        todo(6) 자동 로그인 처리

//        userRepository.save(User.builder()
//                .cuid(userDto.getCuid())
//                .password(userDto.getPassword())
//                .email(userDto.getEmail())
//                .gender(userDto.getGender())
//                .birthDate(userDto.getBirthDate()).build()
//        );

        if(userRepository.existsByEmail(userSignupDto.getEmail())) {
            return ResponseEntity.badRequest().body(new ResponseErrorDto(400,"이미 가입되어 있는 이메일 입니다."));
        }else if(userRepository.existsByCuid(userSignupDto.getCuid())) {
            return ResponseEntity.badRequest().body(new ResponseErrorDto(400,"이미 사용중인 아이디 입니다."));
        }
        else {
            userRepository.save(User.builder()
                .cuid(userSignupDto.getCuid())
                .password(bCryptPasswordEncoder.encode(userSignupDto.getPassword()))
                .email(userSignupDto.getEmail())
                .gender(userSignupDto.getGender())
                .birthDate(userSignupDto.getBirthDate()).build());
        }


        return ResponseEntity.ok().body(new ResponseStatusDto(200,"회원가입 성공"));
    }

    public ResponseEntity validateSignupParameter(Errors errors) {
        HashMap<String,Object> errorMap = new HashMap<>();
        for(FieldError fieldError: errors.getFieldErrors()) {
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return ResponseEntity.badRequest()
                .body(new ResponseErrorsDto(400,errorMap));
    }

//    public ResponseEntity validateLoginParameter(Errors errors) {
//        HashMap<String,Object> errorMap = new HashMap<>();
//        for(FieldError fieldError: errors.getFieldErrors()) {
//            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
//        }
//        return ResponseEntity.badRequest()
//                .body(new ResponseErrorsDto(400,errorMap));
//    }

    public ResponseEntity login(UserLoginDto userLoginDto,HttpServletResponse response) {

//        list(1) 로그인한 이메일이 존재하는지, 비밀번호가 틀리지 않았는지 확인
        if(userRepository.existsByEmail(userLoginDto.getEmail())) {
            User user = userRepository.findByEmail(userLoginDto.getEmail());
            if(bCryptPasswordEncoder.matches(userLoginDto.getPassword(), user.getPassword())){
//            list(2) 토큰 생성
//            todo(3) 토큰 설정
                HashMap<String,Object> hashMap = new HashMap<>();
                ResponseCookie cookie = ResponseCookie.from("accessToken",jwtTokenManager.createAccessToken(user))
                        .domain(domainCookie)
                        .maxAge(24 * 60 * 60) //기간 아마 1일?
                        .sameSite("Strict")
                        .secure(true)
                        .httpOnly(true)
                        .path("/")
                        .build();
                response.addHeader("Set-Cookie",cookie.toString());
                TokenDto tokenDto = new TokenDto(user.getEmail(),user.getRole());
                hashMap.put("auth",tokenDto);
                return ResponseEntity.ok().body(new ResponseDataDto(200, "로그인 성공", hashMap));
            }else {
                return ResponseEntity.badRequest().body(new ResponseErrorDto(400,"비밀번호가 틀렸습니다."));
            }
        }else{
            return ResponseEntity.badRequest().body(new ResponseErrorDto(400,"가입되어 있는 이메일이 없습니다."));
        }
    }

    public ResponseEntity removeToken(HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie.from("accessToken",null)
                .domain(domainCookie)
                .maxAge(0) //기간 0일로 덮어씌어서 초기화
                .sameSite("Strict")
                .secure(true)
                .httpOnly(true)
                .path("/")
                .build();
        response.addHeader("Set-Cookie",cookie.toString());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"토큰 제거 완료"));
    }

    public ResponseEntity validateToken(String accessToken) {
        Claims jwt = jwtTokenManager.validAccessTokenAndReturnBody(accessToken);
        TokenDto tokenDto = new TokenDto(jwt.get("email").toString(), jwt.get("role").toString());
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("auth",tokenDto);
        return ResponseEntity.ok().body(new ResponseDataDto(200, "토큰 검증 완료", hashMap));
    }
}


