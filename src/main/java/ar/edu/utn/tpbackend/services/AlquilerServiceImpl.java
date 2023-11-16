package ar.edu.utn.tpbackend.services;

import ar.edu.utn.tpbackend.models.Alquiler;
import ar.edu.utn.tpbackend.repositories.AlquilerRepository;
import ar.edu.utn.tpbackend.repositories.EstacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlquilerServiceImpl implements AlquilerService{

    private final AlquilerRepository alquilerRepository;

    public AlquilerServiceImpl(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }
    @Override
    public Alquiler add(Alquiler entity) {
        return alquilerRepository.save(entity);
    }

    @Override
    public Alquiler update(Alquiler entity) {
        return null;
    }

    @Override
    public Alquiler delete(Long aLong) {
        return null;
    }

    @Override
    public Alquiler getById(Long aLong) {
        return null;
    }

    @Override
    public List<Alquiler> getAll() {
        return null;
    }
}
