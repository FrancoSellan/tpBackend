package ar.edu.utn.tpbackend.repositories;

import ar.edu.utn.tpbackend.models.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

}
