package ar.edu.utn.tpbackend.repositories;

import ar.edu.utn.tpbackend.models.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EstacionRepository extends JpaRepository<Estacion, Long> {

}