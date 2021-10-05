package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.Empresa;
import com.dio.ControledePonto.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	final EmpresaService empresaService;

	@Autowired
	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	@PostMapping
	public Empresa createEmpresa(@RequestBody Empresa empresa) {
		return empresaService.save(empresa);
	}

	@GetMapping
	public List<Empresa> getEmpresaList() {
		return empresaService.findAll();
	}

	@GetMapping("/{idEmpresa}")
	public ResponseEntity<Empresa> getEmpresaByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
		var empresa = empresaService.getById(idEmpresa).orElseThrow(() -> new IllegalArgumentException(
				"A identificação passada não corresponde a nenhuma " + "empresa"));
		return ResponseEntity.ok(empresa);
	}

	@PutMapping
	public Empresa updateEmpresa(@RequestBody Empresa empresa) {
		return empresaService.update(empresa);
	}

	@DeleteMapping("/{idEmpresa}")
	public void deleteEmpresa(@PathVariable Long idEmpresa) throws Exception {
		try {
			empresaService.delete(idEmpresa);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
