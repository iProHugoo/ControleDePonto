package com.dio.ControledePonto.controller;

import com.dio.ControledePonto.model.Usuario;
import com.dio.ControledePonto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@GetMapping
	public List<Usuario> getUsuarioList() {
		return usuarioService.findAll();
	}

	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> getUsuarioByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
		var usuario = usuarioService.getById(idUsuario).orElseThrow(
				() -> new IllegalArgumentException("A identificação passada não corresponde a nenhum " + "usuario"));
		return ResponseEntity.ok(usuario);
	}

	@PutMapping
	public Usuario updateUsuario(@RequestBody Usuario usuario) {
		return usuarioService.update(usuario);
	}

	@DeleteMapping("/{idUsuario}")
	public void deleteUsuario(@PathVariable Long idUsuario) throws Exception {
		try {
			usuarioService.delete(idUsuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
