package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.Calendario;
import com.dio.ControledePonto.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

	final CalendarioService calendarioService;

	@Autowired
	public CalendarioController(CalendarioService calendarioService) {
		this.calendarioService = calendarioService;
	}

	@PostMapping
	public Calendario createCalendario(@RequestBody Calendario calendario) {
		return calendarioService.save(calendario);
	}

	@GetMapping
	public List<Calendario> getCalendarioList() {
		return calendarioService.findAll();
	}

	@GetMapping("/{idCalendario}")
	public ResponseEntity<Calendario> getCalendarioByID(@PathVariable("idCalendario") Long idCalendario)
			throws Exception {
		var calendario = calendarioService.getById(idCalendario).orElseThrow(() -> new IllegalArgumentException(
				"A identificação passada não corresponde a nenhum " + "calendario"));
		return ResponseEntity.ok(calendario);
	}

	@PutMapping
	public Calendario updateCalendario(@RequestBody Calendario calendario) {
		return calendarioService.update(calendario);
	}

	@DeleteMapping("/{idCalendario}")
	public void deleteCalendario(@PathVariable Long idCalendario) throws Exception {
		try {
			calendarioService.delete(idCalendario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
