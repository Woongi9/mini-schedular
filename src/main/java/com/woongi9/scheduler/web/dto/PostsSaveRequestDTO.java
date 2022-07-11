package com.woongi9.scheduler.web.dto;

import com.woongi9.scheduler.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDTO {

    private String title;
    private String content;
    private int score;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate endDate;

    @Builder
    public PostsSaveRequestDTO(String title, String content,
                               int score,
                               LocalDate startDate, LocalTime startTime,
                               LocalDate endDate, LocalTime endTime) {
        this.title = title;
        this.content = content;
        this.score = score;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .score(score)
                .startDate(startDate)
                .startTime(startTime)
                .endDate(endDate)
                .endTime(endTime)
                .build();
    }
}
