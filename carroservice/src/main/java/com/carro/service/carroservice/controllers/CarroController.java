package com.carro.service.carroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carro.service.carroservice.entities.Carro;
import com.carro.service.carroservice.services.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> getAll() {
        List<Carro> carros = carroService.getAll();
        if (carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable Integer id) {
        Carro carro = carroService.getCarroById(id);
        if (carro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public ResponseEntity<Carro> saveCarro(Carro carro) {
        Carro carroSaved = carroService.saveCarro(carro);
        return ResponseEntity.ok(carroSaved);
    }

    @GetMapping("/usario/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable Integer usuarioId) {
        List<Carro> carros = carroService.getCarrosByUsuarioId(usuarioId);
        if (carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

}
