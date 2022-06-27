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

    private String title;
    private String content;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @Builder
    public PostsSaveRequestDTO(String title, String content,
                               LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.title = title;
        this.content = content;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .startDate(startDateTime)
                .endDate(endDateTime)
                .build();
    }
}
