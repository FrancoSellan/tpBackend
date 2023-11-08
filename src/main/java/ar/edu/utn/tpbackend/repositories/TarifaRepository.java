package ar.edu.utn.tpbackend.repositories;

import ar.edu.utn.tpbackend.models.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {

}