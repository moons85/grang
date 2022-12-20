package com.grang.controller.api;

import com.grang.dto.ResponseDto;
import com.grang.dto.RoomDto;
import com.grang.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoomApiController {

    private final RoomService roomService;

    @PostMapping("/room/userSave/")
    public ResponseDto<Integer> userSave(@RequestBody RoomDto roomDto) {
        roomService.방생성(roomDto);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }
}
