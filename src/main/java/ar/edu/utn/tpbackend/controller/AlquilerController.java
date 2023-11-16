package ar.edu.utn.tpbackend.controller;

import ar.edu.utn.tpbackend.models.Alquiler;
import ar.edu.utn.tpbackend.models.Estacion;
import ar.edu.utn.tpbackend.repositories.AlquilerRepository;
import ar.edu.utn.tpbackend.repositories.EstacionRepository;
import ar.edu.utn.tpbackend.services.AlquilerService;
import ar.edu.utn.tpbackend.services.EstacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alquiler")
public class AlquilerController {

    private final AlquilerService alquilerService;
    private EstacionService estacionService;

    public AlquilerController(AlquilerService alquilerService, EstacionService estacionService) {
        this.alquilerService = alquilerService;
        this.estacionService = estacionService;
    }


    @GetMapping
    private ResponseEntity<List<Alquiler>> getAll(){
        List<Alquiler> lista = alquilerService.getAll();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    private ResponseEntity<Void> addAlbum(@RequestBody Alquiler alquiler){
        alquilerService.add(alquiler);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/{id}")
    private ResponseEntity<Alquiler> iniciarAlquiler(@PathVariable("id") Long id, @RequestBody Alquiler request)
    {

        Alquiler alquiler = new Alquiler();
        Estacion estacion = estacionService.existById(id);
        //List<Estacion> estaciones = estacionService.getAll();
        alquiler.setId_cliente(request.getId_cliente());
        alquiler.setEstado(request.getEstado());
        alquiler.setEstacion_retiro(estacion);
        alquiler.setFecha_hora_retiro(request.getFecha_hora_retiro());
        alquiler.setMonto(request.getMonto());
        alquiler.setId_tarifa(request.getId_tarifa());
        alquilerService.add(alquiler);

        return ResponseEntity.ok(alquiler);
        /*for (Estacion est:estaciones) {
            if(est.equals(estacion)){
                alquiler.setEstacion_retiro(estacion);
            }
        } (estacion != null){
            ;
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
        //nuevaPlaylist.setName(request.getPlaylistName());

        //alquiler.setEstacion_retiro(id);
        alquilerService.add(alquiler);
        return ResponseEntity.ok().build();*/
    }
}
