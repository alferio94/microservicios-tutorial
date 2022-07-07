package com.carro.service.carroservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carro.service.carroservice.entities.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

    List<Carro> findByUsuario(int usuarioId);

}
