package com.woongi9.scheduler.web.controller;

import com.woongi9.scheduler.domain.posts.Posts;
import com.woongi9.scheduler.domain.posts.PostsRepository;
import com.woongi9.scheduler.web.dto.PostsSaveRequestDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalendarControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void post등록() throws Exception {
        //given
        String title = "title";
        String content = "content";
        PostsSaveRequestDTO requestDTO = PostsSaveRequestDTO.builder()
                .title(title)
                .content(content)
                .score(5)
                .startDate(LocalDate.of(2022, 6, 30))
                .startTime(LocalTime.of(20, 7, 15))
                .endDate(LocalDate.of(2022, 7, 11))
                .endTime(LocalTime.of(20, 0, 0))
                .build();

        System.out.println(requestDTO);

        String url = "http://localhost:" + port + "/calendar/register";

        //when
        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, requestDTO, Long.class);

        //then
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getScore()).isEqualTo(5);
        assertThat(all.get(0).getStartDate()).isEqualTo(LocalDate.of(2022, 6, 30));
        assertThat(all.get(0).getStartTime()).isEqualTo(LocalTime.of(20, 7, 15));
        assertThat(all.get(0).getEndDate()).isEqualTo(LocalDate.of(2022, 7, 11));
        assertThat(all.get(0).getEndTime()).isEqualTo(LocalTime.of(20, 0, 0));
    }

}