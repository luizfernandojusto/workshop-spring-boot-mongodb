package com.informaticaconsutoria.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informaticaconsutoria.workshopmongodb.domain.Usuario;
import com.informaticaconsutoria.workshopmongodb.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

}
