package com.example.ssssksss_blog.blog.repository;

import com.example.ssssksss_blog.blog.dao.FirstCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * PackageName : com.example.ssssksss_blog.blog.repository
 * FileName : CategoryRepository
 * Author : 이 수 경
 * Date : 2022-03-16
 * Description :
 */
public interface FirstCategoryRepository extends JpaRepository<FirstCategory,Long> {
    @Modifying
    @Query(value = "insert into first_category (id,name,first_href,line,user_id,position) VALUES (0,:name,:first_href,:line,'ssssksss'," +
            "(select count(temp.position)+1 from (select * from first_category where line = :line) as temp))", nativeQuery = true)
    @Transactional
    void saveFirstCategory(
                @Param("name") String name,
                @Param("first_href") String firstHref,
                @Param("line") int line
            );

    @Modifying
    @Query(value = "select * from first_category", nativeQuery = true)
    @Transactional
    Optional<List<FirstCategory>> findFirstCategory();

    @Modifying
    @Query(value="delete from first_category where first_href = :first_href", nativeQuery = true)
    @Transactional
    void deleteHref(@Param("first_href") String firstHref);

}
