package com.woongi9.scheduler.web.dto;

import com.woongi9.scheduler.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class PostsResponseDTO {
    private Long pno;
    private String title;
    private String content;
    private String name;
    private int score;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;

    public PostsResponseDTO(Posts entity) {
        this.pno = entity.getPno();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.name = entity.getName();
        this.score = entity.getScore();
        this.startDate = entity.getStartDate();
        this.startTime = entity.getStartTime();
        this.endDate = entity.getEndDate();
        this.endTime = entity.getEndTime();
    }

}
