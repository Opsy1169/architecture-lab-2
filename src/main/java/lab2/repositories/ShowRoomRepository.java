package lab2.repositories;

import lab2.entities.Showroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShowRoomRepository extends JpaRepository<Showroom, UUID> {
}
