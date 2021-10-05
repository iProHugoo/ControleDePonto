package com.dio.ControledePonto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.ControledePonto.model.Empresa;
import com.dio.ControledePonto.repository.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

	final EmpresaRepository empresaRepository;

	@Autowired
	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	public Optional<Empresa> getById(Long idEmpresa) {
		return empresaRepository.findById(idEmpresa);
	}

	public Empresa update(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public void delete(Long idEmpresa) {
		empresaRepository.deleteById(idEmpresa);
	}
}
