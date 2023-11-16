package ar.edu.utn.tpbackend.services;

import ar.edu.utn.tpbackend.models.Estacion;
import ar.edu.utn.tpbackend.repositories.EstacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionServiceImpl implements EstacionService {
    private final EstacionRepository estacionRepository;

    public EstacionServiceImpl(EstacionRepository estacionRepository) {
        this.estacionRepository = estacionRepository;
    }

    @Override
    public Estacion add(Estacion entity) {
        estacionRepository.save(entity);
        return entity;
    }

    @Override
    public Estacion update(Estacion entity) {
        return null;
    }

    @Override
    public Estacion delete(Long id) {
        return null;
    }

    @Override
    public Estacion getById(Long id) {
        Optional<Estacion> optionalEstacion = estacionRepository.findById(id);
        return optionalEstacion.orElseThrow();
    }

    @Override
    public List<Estacion> getAll() {
        List<Estacion> estaciones =  this.estacionRepository.findAll();
        return estaciones;
    }

    @Override
    public Estacion existById(Long id) {
        Optional<Estacion> estacion = estacionRepository.findById(id);
        return estacion.orElse(null);
    }
}
