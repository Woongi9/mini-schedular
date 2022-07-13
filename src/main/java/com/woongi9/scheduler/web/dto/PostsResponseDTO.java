package com.woongi9.scheduler.web.dto;

import com.woongi9.scheduler.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class PostsResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String email;
    private int score;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;

    public PostsResponseDTO(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.email = entity.getEmail();
        this.score = entity.getScore();
        this.startDate = entity.getStartDate();
        this.startTime = entity.getStartTime();
        this.endDate = entity.getEndDate();
        this.endTime = entity.getEndTime();
    }

}
