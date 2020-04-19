package com.informaticaconsutoria.workshopmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informaticaconsutoria.workshopmongodb.domain.Usuario;
import com.informaticaconsutoria.workshopmongodb.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> list = usuarioService.listar();
		return ResponseEntity.ok().body(list);
	}

}
