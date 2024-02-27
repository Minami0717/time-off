package com.minami.timeoff.post;

import com.minami.timeoff.post.model.PostInsParam;
import com.minami.timeoff.post.model.ResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
public class PostController {
    private final PostService service;

    @PostMapping
    public ResDto insPost(@RequestBody PostInsParam p) {
        return service.insPost(p);
    }
}
