package com.informaticaconsutoria.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informaticaconsutoria.workshopmongodb.domain.Usuario;
import com.informaticaconsutoria.workshopmongodb.dto.UsuarioDTO;
import com.informaticaconsutoria.workshopmongodb.repository.UsuarioRepository;
import com.informaticaconsutoria.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	public Usuario listarId(String id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Usuario inserir(Usuario usuario) {
		return usuarioRepository.insert(usuario);
	}

	public void deletar(String id) {
		listarId(id);
		usuarioRepository.deleteById(id);
	}

	public Usuario atualizar(Usuario obj) {

		Usuario newObj = listarId(obj.getId());
		atualizarDados(newObj, obj);
		return usuarioRepository.save(newObj);
	}

	private void atualizarDados(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public Usuario fromDTO(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getEmail());
	}

}
