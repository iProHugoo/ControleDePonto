package com.dio.ControledePonto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.ControledePonto.model.TipoData;

@Repository
public interface TipoDataRepository extends JpaRepository<TipoData, Long>{
}
