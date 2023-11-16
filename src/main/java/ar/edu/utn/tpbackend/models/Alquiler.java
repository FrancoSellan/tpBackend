package ar.edu.utn.tpbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="ALQUILERES")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Alquiler {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int id_cliente;

    private int estado;

    @OneToOne
    @JoinColumn(name = "ID")
    private Estacion estacion_retiro;

    @OneToOne
    @JoinColumn(name = "ID")
    private Estacion estacion_devolucion;

    private String fecha_hora_retiro;

    private String fecha_hora_devolucion;

    private double monto;

    @OneToOne
    @JoinColumn(name = "ID")
    private Tarifa id_tarifa;
}
