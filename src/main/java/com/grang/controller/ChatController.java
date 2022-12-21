package com.grang.controller;

import com.grang.config.auth.PrincipalDetail;
import com.grang.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final UserService userService;

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, @AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
        model.addAttribute("sendUser",principalDetail.getUser().getId());
        model.addAttribute("recvUser", userService.회원찾기ById(id).getId());
        return "/detail";
    }
}
