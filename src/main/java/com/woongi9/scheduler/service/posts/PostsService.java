package com.woongi9.scheduler.service.posts;

import com.woongi9.scheduler.domain.posts.Posts;
import com.woongi9.scheduler.domain.posts.PostsRepository;
import com.woongi9.scheduler.web.dto.PostsResponseDTO;
import com.woongi9.scheduler.web.dto.PostsSaveRequestDTO;
import com.woongi9.scheduler.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDTO requestDTO) {

        return postsRepository.save(requestDTO.toEntity()).getId();
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
}
