package com.rojojun.sprignbootweb.service.posts;

import com.rojojun.sprignbootweb.domain.posts.Posts;
import com.rojojun.sprignbootweb.domain.posts.PostsRepository;
import com.rojojun.sprignbootweb.web.dto.PostsResponseDto;
import com.rojojun.sprignbootweb.web.dto.PostsSaveRequestDto;
import com.rojojun.sprignbootweb.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id) {
        return new PostsResponseDto(findBoardById(id));
    }

    public Long update(Long id, PostsUpdateRequestDto postsUpdateRequestDto) {
        Posts posts = findBoardById(id);

        posts.update(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());
        return id;
    }

    private Posts findBoardById(Long id) {
        return postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("사용자가 없습니다. Id=" + id)
        );
    }
}
