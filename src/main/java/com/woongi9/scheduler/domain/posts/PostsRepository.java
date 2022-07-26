package com.woongi9.scheduler.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p WHERE p.endDate >= CURDATE() ORDER BY p.endDate ASC")
    List<Posts> findTimesortPage();

    @Query("SELECT p FROM Posts p WHERE p.endDate >= CURDATE() ORDER BY p.score DESC")
    List<Posts> findPriorityPage();
}
