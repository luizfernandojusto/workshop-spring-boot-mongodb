package com.informaticaconsutoria.workshopmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informaticaconsutoria.workshopmongodb.domain.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		Usuario usuario1 = new Usuario("1", "fernando1", "fernando1@gmail.com");
		Usuario usuario2 = new Usuario("2", "fernando2", "fernando2@gmail.com");

		List<Usuario> list = new ArrayList<>();
		list.addAll(Arrays.asList(usuario1, usuario2));

		return ResponseEntity.ok().body(list);

	}

}
