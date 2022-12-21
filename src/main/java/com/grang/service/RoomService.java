package com.grang.service;

import com.grang.dto.RoomDto;
import com.grang.model.Room;
import com.grang.model.User;
import com.grang.repository.RoomRepository;
import com.grang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    private final UserRepository userRepository;

    public void 방생성(RoomDto roomDto) {
        User sendUser = userRepository.findById(roomDto.getSendUserId())
                .orElseThrow(() -> new IllegalArgumentException("없는 아이디"));
        User recvUser = userRepository.findById(roomDto.getRecvUserId())
                .orElseThrow(() -> new IllegalArgumentException("없는 아이디"));
        Room room = Room.builder()
                .sendUser(sendUser)
                .recvUser(recvUser)
                .build();
        System.out.println("room = " + room);
        roomRepository.save(room);
    }

/*    public Room 방찾기(int id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("방찾기 실패: 방 아이디가 없습니다"));
    }*/

    public List<Room> 방전체찾기(int id) {
        return roomRepository.findByRoom(id);
    }
}
