package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.NivelAcesso;
import com.dio.ControledePonto.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acesso")
public class NivelAcessoController {

	final NivelAcessoService nivelAcessoService;

	@Autowired
	public NivelAcessoController(NivelAcessoService nivelAcessoService) {
		this.nivelAcessoService = nivelAcessoService;
	}

	@PostMapping
	public NivelAcesso createNivelAcesso(NivelAcesso nivelAcesso) {
		return nivelAcessoService.save(nivelAcesso);
	}

	@GetMapping
	public List<NivelAcesso> getNivelAcessoList() {
		return nivelAcessoService.findAll();
	}

	@GetMapping("/{idNivelAcesso}")
	public ResponseEntity<NivelAcesso> getNivelAcessoByID(@PathVariable("idNivelAcesso") Long idNivelAcesso)
			throws Exception {
		var nivelAcesso = nivelAcessoService.getById(idNivelAcesso).orElseThrow(() -> new IllegalArgumentException(
				"A identificação passada não corresponde a nenhum " + "nivel de acesso"));
		return ResponseEntity.ok(nivelAcesso);
	}

	@PutMapping
	public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
		return nivelAcessoService.update(nivelAcesso);
	}

	@DeleteMapping("/{idNivelAcesso}")
	public void deleteNivelAcesso(@PathVariable Long idNivelAcesso) throws Exception {
		try {
			nivelAcessoService.delete(idNivelAcesso);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
