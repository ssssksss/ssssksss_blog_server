package com.example.ssssksss_blog.blog.service;

import com.example.ssssksss_blog.blog.dao.FirstCategory;
import com.example.ssssksss_blog.blog.dao.SecondCategory;
import com.example.ssssksss_blog.blog.dto.FirstCategoryDto;
import com.example.ssssksss_blog.blog.dto.SecondCategoryDto;
import com.example.ssssksss_blog.blog.repository.FirstCategoryRepository;
import com.example.ssssksss_blog.blog.repository.SecondCategoryRepository;
import com.example.ssssksss_blog.commonDto.ResponseDataDto;
import com.example.ssssksss_blog.commonDto.ResponseStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * PackageName : com.example.ssssksss_blog.blog.service
 * FileName : CategoryService
 * Author : 이 수 경
 * Date : 2022-03-16
 * Description :
 */
@Service
public class CategoryService {
    private FirstCategoryRepository firstCategoryRepository;
    private SecondCategoryRepository secondCategoryRepository;

    public CategoryService(FirstCategoryRepository firstCategoryRepository, SecondCategoryRepository secondCategoryRepository) {
        this.firstCategoryRepository = firstCategoryRepository;
        this.secondCategoryRepository = secondCategoryRepository;
    }

    public ResponseEntity addFirstCategory(FirstCategoryDto firstCategoryDto) {
        System.out.println("서비스: addFirstCategory");
        firstCategoryRepository.saveFirstCategory(firstCategoryDto.getName(), firstCategoryDto.getFirstHref(), firstCategoryDto.getLine());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Category Add Success"));
    }

    public ResponseEntity readFirstCategory() {
        System.out.println("서비스: readFirstCategory");
        Optional<List<FirstCategory>> optionalFirstCategories = firstCategoryRepository.findFirstCategory();
        if(optionalFirstCategories.isEmpty()) {
            return ResponseEntity.ok().body(new ResponseStatusDto(200,"카테고리가 1개도 없습니다."));
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("firstCategory", optionalFirstCategories.get());
        return ResponseEntity.ok().body(new ResponseDataDto("read success",hashMap));
    }

    public ResponseEntity removeFirstCategory(FirstCategoryDto firstCategoryDto) {
        System.out.println("서비스: removeFirstCategory");
        firstCategoryRepository.deleteHref(firstCategoryDto.getFirstHref());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Category Remove Success"));
    }

    public ResponseEntity addSecondCategory(SecondCategoryDto secondCategoryDto) {
        System.out.println("서비스: addSecondCategory");
        secondCategoryRepository.saveSecondCategory(secondCategoryDto.getName(), secondCategoryDto.getSecondHref(),secondCategoryDto.getFirstHref());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Category Remove Success"));
    }

    public ResponseEntity readSecondCategory(String firstHref) {
        System.out.println("서비스: readSecondCategory");
        Optional<List<SecondCategory>> optionalSecondCategory = secondCategoryRepository.findSecondCategory("/"+firstHref);
        if(optionalSecondCategory.isEmpty()){
            return ResponseEntity.ok().body(new ResponseStatusDto(200,"아무런 내용이 없습니다."));
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("secondCategory", optionalSecondCategory.get());
        return ResponseEntity.ok().body(new ResponseDataDto("read success",hashMap));
    }

    public ResponseEntity removeSecondCategory(SecondCategoryDto secondCategoryDto) {
        System.out.println("서비스: removeSecondCategory");
        secondCategoryRepository.deleteHref(secondCategoryDto.getSecondHref());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Category Remove Success"));
    }
}
