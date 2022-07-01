package com.woongi9.scheduler.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDTO {
    private Long pnum;
    private Long unum;
    private String title;
    private String content;
    private int score;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @Builder
    public PostsUpdateRequestDTO(Long pnum, Long unum, String title, String content, int score, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.pnum = pnum;
        this.unum = unum;
        this.title = title;
        this.content = content;
        this.score = score;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
