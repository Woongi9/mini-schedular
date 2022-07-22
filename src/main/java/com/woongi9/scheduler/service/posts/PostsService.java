package com.woongi9.scheduler.service.posts;

import com.woongi9.scheduler.domain.posts.Posts;
import com.woongi9.scheduler.domain.posts.PostsRepository;
import com.woongi9.scheduler.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    public PostsResponseDTO findById(Long pno) {
        Posts entity = postsRepository.findById(pno).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + pno));

        return new PostsResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsResponseDTO> findTimesortPage() {
        return postsRepository.findTimesortPage().stream()
                .map(PostsResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsResponseDTO> findPriorityPage() {
        return postsRepository.findPriorityPage().stream()
                .map(PostsResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long pno) {
        Posts post = postsRepository.findById(pno)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. pno=" + pno));

        postsRepository.delete(post);
    }
}
