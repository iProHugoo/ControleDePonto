package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.CategoriaUsuario;
import com.dio.ControledePonto.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaUsuarioController {


	final CategoriaUsuarioService categoriaUsuarioService;

	@Autowired
	public CategoriaUsuarioController(CategoriaUsuarioService categoriaUsuarioService) {
		this.categoriaUsuarioService = categoriaUsuarioService;
	}

	@PostMapping
	public CategoriaUsuario createCategoriaUsario(@RequestBody CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioService.save(categoriaUsuario);
	}

	@GetMapping
	public List<CategoriaUsuario> getCategoriaUsuarioList(){
		return categoriaUsuarioService.findAll();
	}

	@GetMapping("/{idCategoriaUsuario}")
	public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioByID(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario)throws Exception{
		var categoriaUsuario = categoriaUsuarioService.getById(idCategoriaUsuario)
				.orElseThrow(()->new IllegalArgumentException("A identificação passada não corresponde a nenhuma " +
						"categoria de usuario"));
		return ResponseEntity.ok(categoriaUsuario);
	}

	@PutMapping
	public CategoriaUsuario updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
		return categoriaUsuarioService.update(categoriaUsuario);
	}

	@DeleteMapping("/{idCategoriaUsuario}")
	public void deleteCategoriaUsuario(@PathVariable Long idCategoriaUsuario) throws Exception{
		try{
			categoriaUsuarioService.delete(idCategoriaUsuario);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
