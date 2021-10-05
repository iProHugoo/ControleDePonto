package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.Ocorrencia;
import com.dio.ControledePonto.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

	final OcorrenciaService ocorrenciaService;

	@Autowired
	public OcorrenciaController(OcorrenciaService ocorrenciaService) {
		this.ocorrenciaService = ocorrenciaService;
	}

	@PostMapping
	public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
		return ocorrenciaService.save(ocorrencia);
	}

	@GetMapping
	public List<Ocorrencia> getOcorrenciaList() {
		return ocorrenciaService.findAll();
	}

	@GetMapping("/{idOcorrencia}")
	public ResponseEntity<Ocorrencia> getOcorrenciaByID(@PathVariable("idOcorrencia") Long idOcorrencia)
			throws Exception {
		var ocorrencia = ocorrenciaService.getById(idOcorrencia).orElseThrow(() -> new IllegalArgumentException(
				"A identificação passada não corresponde a nenhuma " + "ocorrencia"));
		return ResponseEntity.ok(ocorrencia);
	}

	@PutMapping
	public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia) {
		return ocorrenciaService.update(ocorrencia);
	}

	@DeleteMapping("/{idOcorrencia}")
	public void deleteOcorrencia(@PathVariable Long idOcorrencia) throws Exception {
		try {
			ocorrenciaService.delete(idOcorrencia);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
