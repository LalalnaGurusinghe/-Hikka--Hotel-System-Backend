package com.hikka.HikkaSide.repo;

import com.hikka.HikkaSide.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room , Long> {
}
