package com.woongi9.scheduler.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class PostsUpdateRequestDTO {

    private long pno;
    private String title;
    private String content;
    private String name;
    private int score;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate endDate;

    @Builder
    public PostsUpdateRequestDTO(Long pno, String title, String content,
                                 String name, int score,
                                 LocalDate startDate, LocalTime startTime,
                                 LocalDate endDate, LocalTime endTime) {
        this.pno = pno;
        this.title = title;
        this.content = content;
        this.name = name;
        this.score = score;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
    }
}
