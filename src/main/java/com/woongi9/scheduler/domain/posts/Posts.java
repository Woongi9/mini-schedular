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
    private Long pnum;

    @Column
    private Long unum;

    @Column(length = 30, nullable = true)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content;

    @Column
    private int score;

    @Column
    private LocalDateTime startDateTime;

    @Column
    private LocalDateTime endDateTime;

    @Builder
    public Posts(Long pnum, Long unum, String title, String content, int score, LocalDateTime startDate, LocalDateTime endDate) {
        this.pnum = pnum;
        this.unum = unum;
        this.title = title;
        this.content = content;
        this.startDateTime = startDate;
        this.endDateTime = endDate;
        this.score = score;
    }

    public void update(Long pnum, Long unum, String title, String content, int score, LocalDateTime startDate, LocalDateTime endDate) {
        this.pnum = pnum;
        this.unum = unum;
        this.title = title;
        this.content = content;
        this.startDateTime = startDate;
        this.endDateTime = endDate;
        this.score = score;
    }
}
