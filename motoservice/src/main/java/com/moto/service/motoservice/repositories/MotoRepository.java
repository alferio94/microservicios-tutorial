package com.moto.service.motoservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moto.service.motoservice.entities.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer> {
    List<Moto> findByUsuarioId(int usuarioId);
}
