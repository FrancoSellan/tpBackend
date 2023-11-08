package ar.edu.utn.tpbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import jakarta.persistence.Id;

@Entity(name="ESTACIONES")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Estacion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String fecha_hora_creacion;

    private double latitud;

    private double longitud;

}
