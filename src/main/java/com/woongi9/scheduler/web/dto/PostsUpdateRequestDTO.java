package com.woongi9.scheduler.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDTO {
    private String title;
    private String content;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @Builder
    public PostsUpdateRequestDTO(String title, String content, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.title = title;
        this.content = content;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
