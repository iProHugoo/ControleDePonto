package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.JornadaTrabalho;
import com.dio.ControledePonto.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

	final JornadaTrabalhoService jornadaTrabalhoService;

	@Autowired
	public JornadaTrabalhoController(JornadaTrabalhoService jornadaTrabalhoService) {
		this.jornadaTrabalhoService = jornadaTrabalhoService;
	}

	@PostMapping
	public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoService.save(jornadaTrabalho);
	}

	@GetMapping
	public List<JornadaTrabalho> getJornadaList() {
		return jornadaTrabalhoService.findAll();
	}

	@GetMapping("/{idJornada}")
	public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
		var jornada = jornadaTrabalhoService.getById(idJornada).orElseThrow(() -> new IllegalArgumentException(
				"A identificação passada não corresponde a nenhuma " + "jornada"));
		return ResponseEntity.ok(jornada);
	}

	@PutMapping
	public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoService.update(jornadaTrabalho);
	}

	@DeleteMapping("/{idJornada}")
	public void deleteJornada(@PathVariable Long idJornada) throws Exception {
		try {
			jornadaTrabalhoService.delete(idJornada);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
