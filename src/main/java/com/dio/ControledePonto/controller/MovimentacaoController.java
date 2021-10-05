package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.Movimentacao;
import com.dio.ControledePonto.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

	final MovimentacaoService movimentacaoService;

	@Autowired
	public MovimentacaoController(MovimentacaoService movimentacaoService) {
		this.movimentacaoService = movimentacaoService;
	}

	@PostMapping
	public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao) {
		return movimentacaoService.save(movimentacao);
	}

	@GetMapping
	public List<Movimentacao> getMovimentacaoList() {
		return movimentacaoService.findAll();
	}

	@GetMapping("/{idMovimentacao}")
	public ResponseEntity<Movimentacao> getMovimentacaoByID(@PathVariable("idMovimentacao") Long idMovimentacao)
			throws Exception {
		var movimentacao = movimentacaoService.getById(idMovimentacao).orElseThrow(() -> new IllegalArgumentException(
				"A identificação passada não corresponde a nenhuma " + "movimentacao"));
		return ResponseEntity.ok(movimentacao);
	}

	@PutMapping
	public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao) {
		return movimentacaoService.update(movimentacao);
	}

	@DeleteMapping
	public void deleteMovimentacao(@RequestBody Movimentacao movimentacao) throws Exception {
		try {
			movimentacaoService.delete(movimentacao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
