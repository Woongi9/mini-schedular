package com.woongi9.scheduler.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private int UserID;

    @Column
    private int score;

    @Column
    private LocalDateTime startDateTime;

    @Column
    private LocalDateTime endDateTime;

    @Builder
    public Posts(int userID, String title, String content, int score, LocalDateTime startDate, LocalDateTime endDate) {
        this.UserID = userID;
        this.title = title;
        this.content = content;
        this.startDateTime = startDate;
        this.endDateTime = endDate;
        this.score = score;
    }

    public void update(int userID, String title, String content, int score, LocalDateTime startDate, LocalDateTime endDate) {
        this.UserID = userID;
        this.title = title;
        this.content = content;
        this.startDateTime = startDate;
        this.endDateTime = endDate;
        this.score = score;
    }
}
