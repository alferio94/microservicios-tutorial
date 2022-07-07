package com.moto.service.motoservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.motoservice.entities.Moto;
import com.moto.service.motoservice.services.MotoService;

@RestController
@RequestMapping("/motos")
public class MotoControllers {
    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> getAll() {
        List<Moto> carros = motoService.getAll();
        if (carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> getMotoById(@PathVariable Integer id) {
        Moto moto = motoService.getMotoById(id);
        if (moto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @PostMapping
    public ResponseEntity<Moto> saveMoto(@RequestBody Moto moto) {
        Moto carroSaved = motoService.save(moto);
        return ResponseEntity.ok(carroSaved);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId") int id) {
        List<Moto> motos = motoService.byUsuarioId(id);
        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
}
