package com.example.ssssksss_blog.blog.repository;
import com.example.ssssksss_blog.blog.dao.SecondCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * PackageName : com.example.ssssksss_blog.blog.repository
 * FileName : SecondCategoryRepository
 * Author : 이 수 경
 * Date : 2022-03-17
 * Description :
 */
public interface SecondCategoryRepository  extends JpaRepository<SecondCategory,Long> {

    @Modifying
    @Query(value = "select * from second_category where first_href = :first_href", nativeQuery = true)
    @Transactional
    Optional<List<SecondCategory>> findSecondCategory(
            @Param("first_href") String firstHref
    );

    @Modifying
    @Query(value = "insert into second_category (id,name,second_href,first_href,user_id,position) " +
            "VALUES (0,:name,:second_href,:first_href,'ssssksss',(select count(temp.position)+1 " +
            "from (select * from second_category where first_href = :first_href) as temp))", nativeQuery = true)
    @Transactional
    void saveSecondCategory(
            @Param("name") String name,
            @Param("second_href") String secondHref,
            @Param("first_href") String firstHref
    );

    @Modifying
    @Query(value="delete from second_category where second_href = :second_href", nativeQuery = true)
    @Transactional
    void deleteHref(@Param("second_href") String secondHref);


}
