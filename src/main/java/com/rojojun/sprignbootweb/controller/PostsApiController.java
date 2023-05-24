package com.rojojun.sprignbootweb.controller;

import com.rojojun.sprignbootweb.service.posts.PostsService;
import com.rojojun.sprignbootweb.web.dto.PostsResponseDto;
import com.rojojun.sprignbootweb.web.dto.PostsSaveRequestDto;
import com.rojojun.sprignbootweb.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }



//    @PutMapping("/api/v1/posts/{id}")
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto) {
//        return postsService.update(id, postsUpdateRequestDto);
//    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
