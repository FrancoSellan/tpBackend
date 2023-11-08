package ar.edu.utn.tpbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity(name="ALQUILERES")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Alquiler {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private int id_cliente;

    private int estado;

    @OneToOne
    @JoinColumn(name = "ESTACION_RETIRO")
    private Estacion estacion_retiro;

    @OneToOne
    @JoinColumn(name = "ESTACION_DEVOLUCION")
    private Estacion estacion_devolucion;

    private String fecha_hora_retiro;

    private String fecha_hora_devolucion;

    private int monto;

    @OneToOne
    @JoinColumn(name = "ID_TARIFA")
    private Tarifa id_tarifa;
}
