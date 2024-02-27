package com.minami.timeoff.post.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResDto {
    private boolean success;
    private String msg;
}
