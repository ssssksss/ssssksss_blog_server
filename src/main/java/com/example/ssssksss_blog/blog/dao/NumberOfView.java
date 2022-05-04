package com.example.ssssksss_blog.blog.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * PackageName : com.example.ssssksss_blog.blog.dao
 * FileName : Count
 * Author : 이 수 경
 * Date : 2022-04-29
 * Description :
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="number_of_view")
public class NumberOfView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="access_date", nullable = false)
    private LocalDate accessDate;
    @Column(name="client_ip", nullable = false)
    private String clientIp;
}
