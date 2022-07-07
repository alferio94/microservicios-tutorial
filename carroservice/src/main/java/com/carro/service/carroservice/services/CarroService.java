package com.carro.service.carroservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carro.service.carroservice.entities.Carro;
import com.carro.service.carroservice.repositories.CarroRepository;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAll() {
        return carroRepository.findAll();
    }

    public Carro getCarroById(Integer id) {
        return carroRepository.findById(id).orElse(null);
    }

    public Carro saveCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> getCarrosByUsuarioId(Integer usuarioId) {
        return carroRepository.findByUsuario(usuarioId);
    }

}
