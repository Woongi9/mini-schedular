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

    private int userID;
    private int score;
    private String title;
    private String content;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @Builder
    public PostsSaveRequestDTO(int userID, String title, String content, int score,
                               LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.userID = userID;
        this.title = title;
        this.content = content;
        this.score = score;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Posts toEntity() {
        return Posts.builder()
                .userID(userID)
                .title(title)
                .content(content)
                .score(score)
                .startDate(startDateTime)
                .endDate(endDateTime)
                .build();
    }
}
