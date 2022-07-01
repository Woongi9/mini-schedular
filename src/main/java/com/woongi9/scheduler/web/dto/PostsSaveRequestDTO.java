package com.woongi9.scheduler.web.dto;

import com.woongi9.scheduler.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDTO {

    private Long pnum;
    private Long unum;
    private int score;
    private String title;
    private String content;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @Builder
    public PostsSaveRequestDTO(Long pnum, Long unum, String title, String content, int score,
                               LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.pnum = pnum;
        this.unum = unum;
        this.title = title;
        this.content = content;
        this.score = score;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Posts toEntity() {
        return Posts.builder()
                .pnum(pnum)
                .unum(unum)
                .title(title)
                .content(content)
                .score(score)
                .startDate(startDateTime)
                .endDate(endDateTime)
                .build();
    }
}
