package lab2.services;

import lab2.entities.Showroom;
import lab2.repositories.ShowroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShowroomService {

    @Autowired
    private final ShowroomRepository showroomRepository;

    public ShowroomService(ShowroomRepository showroomRepository) {
        this.showroomRepository = showroomRepository;
    }

    public List<Showroom> findAll() {
        return showroomRepository.findAll();
    }

    public Showroom findShowroomById(UUID id) {
        return showroomRepository.findById(id).get();
    }

    public Showroom saveShowroom(Showroom showroom) {
        if (showroom.getId() == null) {
            showroom.setId(UUID.randomUUID());
        }
        return showroomRepository.save(showroom);
    }

    public void deleteCar(Showroom showroom) {
        showroomRepository.delete(showroom);
    }
}
