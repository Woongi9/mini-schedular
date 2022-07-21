package com.woongi9.scheduler.service.posts;

import com.woongi9.scheduler.domain.posts.Posts;
import com.woongi9.scheduler.domain.posts.PostsRepository;
import com.woongi9.scheduler.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDTO requestDTO) {

        return postsRepository.save(requestDTO.toEntity()).getPno();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDTO requestDTO) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다. id = " + id));
        posts.update(requestDTO.getTitle(), requestDTO.getContent(), requestDTO.getScore(),
                requestDTO.getStartDate(), requestDTO.getStartTime(),
                requestDTO.getEndDate(), requestDTO.getEndTime());

        return id;
    }

    public PostsResponseDTO findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDTO(entity);
    }

//    public PageResultDTO<PostsSaveRequestDTO, Object[]> getTimesortList(PageRequestDTO requestDTO) {
//        log.info("Search Timesort Post Page ...............");
//
//        Function<Object[], PostsSaveRequestDTO> fn = (arr -> entitiesToDTO(
//
//        ))
//    }

    @Transactional(readOnly = true)
    public List<PostsResponseDTO> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsResponseDTO::new)
                .collect(Collectors.toList());
    }
}
