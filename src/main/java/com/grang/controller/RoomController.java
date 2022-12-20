package com.grang.controller;

import com.grang.model.Room;
import com.grang.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/chat/{id}")
    public String chat(@PathVariable int id, Model model) {
        List<Room> rooms = roomService.방전체찾기(id);
        model.addAttribute("rooms", rooms);
        return "/chat";
    }

}
