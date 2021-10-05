package com.dio.ControledePonto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.ControledePonto.model.Calendario;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
}
