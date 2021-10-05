package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.Localidade;
import com.dio.ControledePonto.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

	final LocalidadeService localidadeService;

	@Autowired
	public LocalidadeController(LocalidadeService localidadeService) {
		this.localidadeService = localidadeService;
	}

	@PostMapping
	public Localidade createLocalidade(@RequestBody Localidade localidade) {
		return localidadeService.save(localidade);
	}

	@GetMapping
	public List<Localidade> getLocalidadeList() {
		return localidadeService.findAll();
	}

	@GetMapping("/{idLocalidade}")
	public ResponseEntity<Localidade> getLocalidadeByID(@PathVariable("idLocalidade") Long idLocalidade)
			throws Exception {
		var localidade = localidadeService.getById(idLocalidade).orElseThrow(() -> new IllegalArgumentException(
				"A identificação passada não corresponde a nenhuma " + "localidade"));
		return ResponseEntity.ok(localidade);
	}

	@PutMapping
	public Localidade updateLocalidade(@RequestBody Localidade localidade) {
		return localidadeService.update(localidade);
	}

	@DeleteMapping("/{idLocalidade}")
	public void deleteLocalidade(@PathVariable Long idLocalidade) throws Exception {
		try {
			localidadeService.delete(idLocalidade);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
