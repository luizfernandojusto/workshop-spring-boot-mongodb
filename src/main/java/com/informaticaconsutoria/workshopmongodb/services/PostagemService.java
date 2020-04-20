package com.informaticaconsutoria.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informaticaconsutoria.workshopmongodb.domain.Postagem;
import com.informaticaconsutoria.workshopmongodb.repository.PostagemRepository;
import com.informaticaconsutoria.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;

	public Postagem listarId(String id) {
		Optional<Postagem> obj = postagemRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Postagem> listaIdTitulo(String texto){
		return postagemRepository.findByTituloContainingIgnoreCase(texto);		
	}

}
