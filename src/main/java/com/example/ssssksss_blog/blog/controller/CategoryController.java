package com.example.ssssksss_blog.blog.controller;

import com.example.ssssksss_blog.blog.dto.FirstCategoryDto;
import com.example.ssssksss_blog.blog.dto.SecondCategoryDto;
import com.example.ssssksss_blog.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * PackageName : com.example.ssssksss_blog.blog.controller
 * FileName : CategoryController
 * Author : 이 수 경
 * Date : 2022-03-16
 * Description :
 */
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @RequestMapping(value="/ssssksss/first-category/add", method= RequestMethod.POST)
    public ResponseEntity addFirstCategory(@RequestBody FirstCategoryDto firstCategoryDto) {
        return categoryService.addFirstCategory(firstCategoryDto);
    }
    @RequestMapping(value="/ssssksss/first-category/read", method= RequestMethod.GET)
    public ResponseEntity readFirstCategory() {
        return categoryService.readFirstCategory();
    }
    @RequestMapping(value="/ssssksss/first-category/remove", method= RequestMethod.POST)
    public ResponseEntity removeFirstCategory(@RequestBody FirstCategoryDto firstCategoryDto) {
        return categoryService.removeFirstCategory(firstCategoryDto);
    }
    @RequestMapping(value="/ssssksss/second-category/add", method= RequestMethod.POST)
    public ResponseEntity addSecondCategory(@RequestBody SecondCategoryDto secondCategoryDto) {
        return categoryService.addSecondCategory(secondCategoryDto);
    }
    @RequestMapping(value="/ssssksss/second-category/read", method= RequestMethod.GET)
    public ResponseEntity readSecondCategory(@RequestParam(name = "firstHref") String firstHref) {
        return categoryService.readSecondCategory(firstHref);
    }
    @RequestMapping(value="/ssssksss/second-category/remove", method= RequestMethod.POST)
    public ResponseEntity removeSecondCategory(@RequestBody SecondCategoryDto secondCategoryDto) {
        return categoryService.removeSecondCategory(secondCategoryDto);
    }
}
