package ar.edu.utn.tpbackend.services;

import ar.edu.utn.tpbackend.models.Estacion;
import ar.edu.utn.tpbackend.repositories.EstacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public List<Estacion> getAll() {
        List<Estacion> estaciones =  this.estacionRepository.findAll();
        return estaciones;
    }
}
