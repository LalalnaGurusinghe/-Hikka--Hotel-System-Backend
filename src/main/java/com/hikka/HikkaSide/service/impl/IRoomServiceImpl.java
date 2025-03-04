package com.hikka.HikkaSide.service.impl;

import com.hikka.HikkaSide.model.Room;
import com.hikka.HikkaSide.repo.RoomRepo;
import com.hikka.HikkaSide.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class IRoomServiceImpl implements IRoomService {

    @Autowired
    private RoomRepo roomRepo;
    @Override
    public Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws IOException, SQLException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);

        if(!photo.isEmpty()){
            byte[] photoBytes = photo.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes);
            room.setPhoto(photoBlob);
        }
        roomRepo.save(room);
        return room;
    }
}
