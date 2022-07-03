package com.woongi9.scheduler.web.dto;

import com.woongi9.scheduler.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class PostsResponseDTO {
    private Long pnum;
    private Long unum;
    private int userID;
    private String title;
    private String content;
    private int score;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public PostsResponseDTO(Posts entity) {
        this.pnum = entity.getPnum();
        this.unum = entity.getUnum();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.score = entity.getScore();
        this.startDateTime = entity.getStartDateTime();
        this.endDateTime = entity.getEndDateTime();
    }

}
