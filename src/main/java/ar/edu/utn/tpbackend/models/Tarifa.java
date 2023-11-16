package ar.edu.utn.tpbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity(name="TARIFAS")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tarifa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TIPO_TARIFA")
    private int tipoTarifa;

    private char definicion;

    private int dia_semana;

    private int dia_mes;

    private int mes;

    private int anio;

    private double monto_fijo_alquiler;

    private double monto_fijo_fraccion;

    private double monto_hora;

    private double monto_km;
}
