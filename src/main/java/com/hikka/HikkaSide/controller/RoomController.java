package com.hikka.HikkaSide.controller;

import com.hikka.HikkaSide.model.Room;
import com.hikka.HikkaSide.response.RoomResponse;
import com.hikka.HikkaSide.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/hikka/rooms")
@CrossOrigin
public class RoomController {
    @Autowired
    private IRoomService roomService;

    @PostMapping("/add/new-rooms")
    public ResponseEntity<RoomResponse> addNewRoom(
           @RequestParam("photo") MultipartFile photo ,
           @RequestParam("roomType") String roomType ,
           @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {

        Room savedRoom = roomService.addNewRoom(photo , roomType , roomPrice);

        RoomResponse response = new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());

        return ResponseEntity.ok(response);


    }
}
