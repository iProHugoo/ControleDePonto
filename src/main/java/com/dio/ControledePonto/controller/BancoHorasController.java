package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.BancoHoras;
import com.dio.ControledePonto.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancoHoras")
public class BancoHorasController {

	final BancoHorasService bancoHorasService;

	@Autowired
	public BancoHorasController(BancoHorasService bancoHorasService) {
		this.bancoHorasService = bancoHorasService;
	}

	@PostMapping
	public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras) {
		return bancoHorasService.save(bancoHoras);
	}

	@GetMapping
	public List<BancoHoras> getBancoHorasList() {
		return bancoHorasService.findAll();
	}

	@GetMapping("/{idBancoHoras}")
	public ResponseEntity<BancoHoras> getBancoHorasByID(@PathVariable("idBancoHoras") Long idBancoHoras)
			throws Exception {
		var bancoHoras = bancoHorasService.getById(idBancoHoras).orElseThrow(() -> new IllegalArgumentException(
				"A identificação passada não corresponde a nenhum" + "banco de horas"));
		return ResponseEntity.ok(bancoHoras);
	}

	@PutMapping
	public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras) {
		return bancoHorasService.update(bancoHoras);
	}

	@DeleteMapping
	public void deleteBancoHoras(@RequestBody BancoHoras bancoHoras) throws Exception {
		try {
			bancoHorasService.delete(bancoHoras);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
