package com.example.ssssksss_blog.blog.repository;

import com.example.ssssksss_blog.blog.dao.NumberOfView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

/**
 * PackageName : com.example.ssssksss_blog.blog.repository
 * FileName : ViewRepository
 * Author : 이 수 경
 * Date : 2022-04-30
 * Description :
 */
public interface ViewRepository extends JpaRepository<NumberOfView,Long> {
    Boolean existsByAccessDateAndClientIp(LocalDate accessDate, String clientiP);
    Long countByAccessDate(LocalDate accessDate);
}
