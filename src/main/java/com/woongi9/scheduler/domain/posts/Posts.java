package com.woongi9.scheduler.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE", length = 500, nullable = false)
    private String title;

    @Column(name = "CONTENT", columnDefinition = "TEXT", nullable = false)
    private String content;
//    @Column(name = "CONTENT")
//    private String content;

    @Column(name = "SCORE")
    private int score;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "START_TIME")
    private LocalTime startTime;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "END_TIME")
    private LocalTime endTime;

    @Builder
    public Posts(String title, String content,
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

    public void update(String title, String content,
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
}
