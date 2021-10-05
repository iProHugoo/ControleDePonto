package com.dio.ControledePonto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.ControledePonto.model.Ocorrencia;
import com.dio.ControledePonto.repository.OcorrenciaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

	final OcorrenciaRepository ocorrenciaRepository;

	@Autowired
	public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
		this.ocorrenciaRepository = ocorrenciaRepository;
	}

	public Ocorrencia save(Ocorrencia ocorrencia) {
		return ocorrenciaRepository.save(ocorrencia);
	}

	public List<Ocorrencia> findAll() {
		return ocorrenciaRepository.findAll();
	}

	public Optional<Ocorrencia> getById(Long idOcorrencia) {
		return ocorrenciaRepository.findById(idOcorrencia);
	}

	public Ocorrencia update(Ocorrencia ocorrencia) {
		return ocorrenciaRepository.save(ocorrencia);
	}

	public void delete(Long idOcorrencia) {
		ocorrenciaRepository.deleteById(idOcorrencia);
	}
}
