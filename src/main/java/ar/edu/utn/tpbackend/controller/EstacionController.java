package ar.edu.utn.tpbackend.controller;

import ar.edu.utn.tpbackend.models.Estacion;
import ar.edu.utn.tpbackend.repositories.EstacionRepository;
import ar.edu.utn.tpbackend.services.EstacionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/estacion")
public class EstacionController {
    private final EstacionService estacionService;
    private final EstacionRepository estacionRepository;

    public EstacionController(EstacionService estacionService, EstacionRepository estacionRepository) {
        this.estacionService = estacionService;
        this.estacionRepository = estacionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Estacion>> getAll() {
        List<Estacion> values = this.estacionService.getAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/cercana/{id}")
    public ResponseEntity<Estacion> obtenerEstacionMasCercana(@PathVariable Long id) {
        // Obtener la estación correspondiente al ID proporcionado por el usuario
        Estacion estacionSeleccionada = estacionRepository.findById(id).orElse(null);

        if (estacionSeleccionada == null) {
            return ResponseEntity.notFound().build();
        }

        // Encontrar la estación más cercana a las coordenadas de la estación seleccionada
        Estacion estacionMasCercana = encontrarEstacionMasCercana(estacionSeleccionada);

        return ResponseEntity.ok(estacionMasCercana);
    }

    private Estacion encontrarEstacionMasCercana(Estacion estacionSeleccionada) {
        List<Estacion> todasLasEstaciones = estacionRepository.findAll();

        Estacion estacionMasCercana = null;
        double distanciaMasCercana = Double.MAX_VALUE;

        for (Estacion estacion : todasLasEstaciones) {
            if (estacion.getId() == estacionSeleccionada.getId()) {
                continue; // Evitar comparar con la misma estación
            }

            double distancia = calcularDistanciaAproximada(
                    estacionSeleccionada.getLatitud(),
                    estacionSeleccionada.getLongitud(),
                    estacion.getLatitud(),
                    estacion.getLongitud()
            );

            if (distancia < distanciaMasCercana) {
                distanciaMasCercana = distancia;
                estacionMasCercana = estacion;
            }
        }

        return estacionMasCercana;
    }

    private double calcularDistanciaAproximada(double lat1, double lon1, double lat2, double lon2) {
        double latDiff = Math.abs(lat1 - lat2);
        double lonDiff = Math.abs(lon1 - lon2);
        double distancia = latDiff + lonDiff;
        return distancia;
    }

    @PostMapping
    public ResponseEntity<String> agregarNuevaEstacion(@RequestBody Estacion nuevaEstacion) {
        estacionService.add(nuevaEstacion);
        return new ResponseEntity<>("Estación agregada correctamente", HttpStatus.CREATED);
    }
}
