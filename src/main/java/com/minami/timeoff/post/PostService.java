package com.minami.timeoff.post;

import com.minami.timeoff.common.repository.PostRepository;
import com.minami.timeoff.common.utils.ResultUtils;
import com.minami.timeoff.post.model.PostInsParam;
import com.minami.timeoff.post.model.ResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository rep;

    public ResDto insPost(PostInsParam p) {
        try {
//            rep.save(Post.builder()
//                    .title()
//                    .build());
            int a = 1/0;
            return ResultUtils.setSuccessResult();
        } catch (Exception e) {
            return ResultUtils.setFailResult(e.getMessage());
        }
    }
}
