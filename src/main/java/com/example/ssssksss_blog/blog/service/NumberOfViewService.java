package com.example.ssssksss_blog.blog.service;

import com.example.ssssksss_blog.blog.dao.NumberOfView;
import com.example.ssssksss_blog.blog.dto.ViewDto;
import com.example.ssssksss_blog.blog.repository.ViewRepository;
import com.example.ssssksss_blog.commonDto.ResponseDataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * PackageName : com.example.ssssksss_blog.blog.service
 * FileName : VisitService
 * Author : 이 수 경
 * Date : 2022-04-05
 * Description :
 */
@Service
public class NumberOfViewService {

    private ViewRepository viewRepository;

    public NumberOfViewService(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    public ResponseEntity visitCount(String ip) {
        if(!viewRepository.existsByAccessDateAndClientIp(LocalDate.now(),ip)){
            viewRepository.save(
                    NumberOfView.builder()
                            .clientIp(ip)
                            .accessDate(LocalDate.now())
                            .build());
        }
        ViewDto viewDto = new ViewDto(
                    viewRepository.countByAccessDate(LocalDate.now()),
                    viewRepository.countByAccessDate(LocalDate.now().minusDays(1)),
                    viewRepository.count()
                );
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("view",viewDto);
        return ResponseEntity.ok().body(new ResponseDataDto(200, "블로그 조회", hashMap));
    }
}
