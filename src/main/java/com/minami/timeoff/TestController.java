package com.minami.timeoff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/oauth/redirect")
    public String getRedirect() {
        return "<h1>success</h1>";
    }
}
