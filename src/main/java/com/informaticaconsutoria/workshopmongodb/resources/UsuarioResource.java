package com.informaticaconsutoria.workshopmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informaticaconsutoria.workshopmongodb.domain.Usuario;
import com.informaticaconsutoria.workshopmongodb.dto.UsuarioDTO;
import com.informaticaconsutoria.workshopmongodb.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listar() {
		List<Usuario> list = usuarioService.listar();
		List<UsuarioDTO> listDTO = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());		
		return ResponseEntity.ok().body(listDTO);
	}

}
