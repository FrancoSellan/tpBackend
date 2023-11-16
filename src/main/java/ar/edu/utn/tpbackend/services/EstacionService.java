package ar.edu.utn.tpbackend.services;

import ar.edu.utn.tpbackend.models.Estacion;


public interface EstacionService extends Service<Estacion, Long>{
    Estacion existById(Long id);

    //public Estacion add(Estacion nuevaEstacion);
}
