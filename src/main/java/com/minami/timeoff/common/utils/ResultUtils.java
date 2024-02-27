package com.minami.timeoff.common.utils;

import com.minami.timeoff.post.model.ResDto;

public class ResultUtils {
    public static ResDto setSuccessResult() {
        return ResDto.builder()
                .success(true)
                .msg("Success")
                .build();
    }
    public static ResDto setFailResult(String msg) {
        return ResDto.builder()
                .success(false)
                .msg(msg)
                .build();
    }
}
