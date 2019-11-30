package lab2.repositories;

import lab2.entities.Showroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShowroomRepository extends JpaRepository<Showroom, UUID> {
    @Override
    List<Showroom> findAll();

    Optional<Showroom> findById(UUID id);

    @Override
    Showroom save(Showroom s);

    @Override
    void delete(Showroom s);
}
