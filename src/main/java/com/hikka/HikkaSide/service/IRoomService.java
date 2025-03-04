package com.hikka.HikkaSide.service;

import com.hikka.HikkaSide.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public interface IRoomService {
    public Room addNewRoom(MultipartFile photo , String roomType , BigDecimal roomPrice) throws IOException, SQLException;
}
