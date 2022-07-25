package com.woongi9.scheduler.web.controller;

import com.woongi9.scheduler.domain.posts.Posts;
import com.woongi9.scheduler.domain.posts.PostsRepository;
import com.woongi9.scheduler.web.dto.PostsSaveRequestDTO;
import com.woongi9.scheduler.web.dto.PostsUpdateRequestDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsApiControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @Autowired
//    private PostsRepository postsRepository;
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        postsRepository.deleteAll();
//    }
//
//    @Test
//    public void post등록() throws Exception {
//        //given
//        String title = "title";
//        String content = "content";
//        PostsSaveRequestDTO requestDTO = PostsSaveRequestDTO.builder()
//                .title(title)
//                .content(content)
////                .startDateTime(LocalDateTime.of(2022, 6, 30, 12, 0, 0))
////                .endDateTime(LocalDateTime.of(2022, 7, 28, 14, 0, 0))
//                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/posts";
//
//        //when
//        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, requestDTO, Long.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Posts> all = postsRepository.findAll();
//        assertThat(all.get(0).getTitle()).isEqualTo(title);
//        assertThat(all.get(0).getContent()).isEqualTo(content);
//    }
//
//    @Test
//    public void Posts_수정() throws Exception {
//        //given
//        Posts savedPosts = postsRepository.save(Posts.builder()
//                .title("title")
//                .content("content")
////                .startDate(LocalDateTime.of(2022, 6, 28, 12, 0, 0))
////                .endDate(LocalDateTime.of(2022, 12, 31, 14, 0, 0))
//                .build());
//
//        Long updateId = savedPosts.getPno();
//        String expectedTitle = "title2";
//        String expectedContent = "content2";
//        LocalDateTime expectedStartTime = LocalDateTime.of(2022, 7, 1, 12, 0, 0);
//        LocalDateTime expectedEndTime = LocalDateTime.of(2022, 12, 15, 12, 0, 0);
//
//        PostsUpdateRequestDTO requestDTO = PostsUpdateRequestDTO.builder()
//                .title(expectedTitle)
//                .content(expectedContent)
////                .startDateTime(expectedStartTime)
////                .endDateTime(expectedEndTime)
//                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;
//
//        HttpEntity<PostsUpdateRequestDTO> requestEntity = new HttpEntity<>(requestDTO);
//
//        //when
//        ResponseEntity<Long> responseEntity = testRestTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Posts> all = postsRepository.findAll();
//        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
//        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
////        assertThat(all.get(0).getStartDateTime()).isEqualTo(expectedStartTime);
////        assertThat(all.get(0).getEndDateTime()).isEqualTo(expectedEndTime);
//    }
}