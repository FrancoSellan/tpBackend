package ar.edu.utn.tpbackend.services;

import ar.edu.utn.tpbackend.models.Estacion;


public interface EstacionService extends Service<Estacion, Long>{

    public Estacion add(Estacion nuevaEstacion);
}
