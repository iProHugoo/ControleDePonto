package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.TipoData;
import com.dio.ControledePonto.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoData")
public class TipoDataController {

	final TipoDataService tipoDataService;

	@Autowired
	public TipoDataController(TipoDataService tipoDataService) {
		this.tipoDataService = tipoDataService;
	}

	@PostMapping
	public TipoData createTipoData(@RequestBody TipoData tipoData) {
		return tipoDataService.save(tipoData);
	}

	@GetMapping
	public List<TipoData> getTipoDataList() {
		return tipoDataService.findAll();
	}

	@GetMapping("/{idTipoData}")
	public ResponseEntity<TipoData> getTipoDataByID(@PathVariable("idTipoData") Long idTipoData) throws Exception {
		var tipoData = tipoDataService.getById(idTipoData).orElseThrow(() -> new IllegalArgumentException(
				"A identificação passada não corresponde a nenhum " + "tipoData"));
		return ResponseEntity.ok(tipoData);
	}

	@PutMapping
	public TipoData updateTipoData(@RequestBody TipoData tipoData) {
		return tipoDataService.update(tipoData);
	}

	@DeleteMapping("/{idTipoSala}")
	public void deleteTipoSala(@PathVariable Long idTipoData) throws Exception {
		try {
			tipoDataService.delete(idTipoData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
