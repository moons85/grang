package com.grang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/detail")
    public String detail() {
        return "/detail";
    }
}
